package RateLimiting;

public class Main {
    
    public static void main(String[] args) {
        
        RateLimiter fixedWindow = new RateLimiter(
            new FixedWindowStrategy(5, 60_000)
        );

        RateLimiter slidingWindow = new RateLimiter(
            new SlidingWindowLogStrategy(5, 60_000)
        );

        RateLimiter tokenBucket = new RateLimiter(
            new TokenBucketStrategy(5, 60_000)
        );

        
        RateLimiter leakyBucket = new RateLimiter(
            new LeakyBucketStrategy(5, 1.0)
        );

        // Same API , diff algorithms

        System.out.println(
            fixedWindow.allowRequest("user-101")
        );
    
        System.out.println(
            slidingWindow.allowRequest("user-101")
        );

        System.out.println(
            tokenBucket.allowRequest("user-101")
        );

        System.out.println(
            leakyBucket.allowRequest("user-101")
        );


    }
}
