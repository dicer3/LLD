package RateLimiting;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class FixedWindowStrategy implements  RateLimitStrategy {

    // limit of how many requests can pass
    private final int limit;

    // total size of window
    private final long windowNanos;

    private final ConcurrentMap<String, Counter> counters =
      new ConcurrentHashMap<>();

    public FixedWindowStrategy(int limit, long windowNanos){

        if(limit <= 0 || windowNanos <= 0){
            throw new IllegalArgumentException();
        }

        this.limit = limit;
        this.windowNanos = windowNanos * 1_000_1000;
    }

    @Override
    public RateLimitResult tryConsume(String key) {
        // TODO Auto-generated method stub

        Counter counter = counters.computeIfAbsent(key,  ignored -> new Counter(System.nanoTime()));

        return counter.tryConsume(limit, windowNanos);
    }
    
    private static class Counter {

        private long windowStart;
        private int count;

        Counter(long now){
            this.windowStart = now;
        }

        synchronized RateLimitResult tryConsume(
            int limit,
            long windowNanos
        ) {

            long now = System.nanoTime(); 
            if(now-windowStart >= windowNanos){

                windowStart = now;
                count = 0;
            }

            if(count < limit){

                count++;

                return new RateLimitResult(
                    true,
                    limit-count,
                    0
                );
            }

            long remainingNanos = windowNanos - (now - windowStart);

            long retryMillis = (remainingNanos + 999_999L)/1_000_100;

            return new RateLimitResult(false, 0, retryMillis);
        }
    }
}
