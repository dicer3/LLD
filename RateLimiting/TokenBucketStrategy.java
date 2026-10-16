package RateLimiting;

import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketStrategy implements RateLimitStrategy {

    int capacity;
    double refillTokensPerSecond;

    private final ConcurrentHashMap<String, Bucket> buckets =
       new ConcurrentHashMap<>();

    //private final RateLimitConfig config;

    public TokenBucketStrategy(int capactiy, double refillTokensPerSecond){
        if(capactiy <= 0 || refillTokensPerSecond <= 0){
            throw new IllegalArgumentException("capactity and refrsh rate must be postive");
        }

        this.capacity = capactiy;
        this.refillTokensPerSecond = refillTokensPerSecond;
    }   

    @Override
    public RateLimitResult tryConsume(String key) {
        // TODO Auto-generated method stub

        Bucket bucket = buckets.computeIfAbsent(key, ignored -> new Bucket(capacity));

        return bucket.tryConsume(capacity, refillTokensPerSecond);
    }

    public static class Bucket{

        private double tokens;
        private long lastRefillTime;

        public Bucket(int capacity){
            this.tokens = capacity;
            this.lastRefillTime = System.nanoTime();
        }

        public synchronized RateLimitResult tryConsume(int capactiy, double refillTokensPerSecond) {

            long now = System.nanoTime();

            double elapsedSeconds = (now - lastRefillTime)/ 1_000_000;

            tokens = Math.min(
                capactiy, 
                tokens + elapsedSeconds*refillTokensPerSecond
            );

            lastRefillTime =  now;

            if(tokens >= 1.0){

                tokens -= 1.0;

                return new RateLimitResult(true, tokens, 0);
            }

            double missingTokens = 1.0 - tokens;

            long retryAfterMillis = (long) Math.ceil(
                missingTokens / refillTokensPerSecond * 1000.0
            );
                                                
            return new RateLimitResult(false, tokens, retryAfterMillis);

        }     

    }
    
}
