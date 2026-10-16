package RateLimiting;

public interface RateLimitStrategy {
    RateLimitResult tryConsume(String key);
}
