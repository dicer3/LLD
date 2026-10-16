package RateLimiting;

public class RateLimiter {
    
    private final RateLimitStrategy strategy;

    public RateLimiter(RateLimitStrategy strategy){
        this.strategy = strategy;
    }

    public RateLimitResult allowRequest(String userId){
        return strategy.tryConsume(userId);
    }
}
