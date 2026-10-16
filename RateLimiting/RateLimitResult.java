package RateLimiting;

public record RateLimitResult (
    boolean allowed,
    double remainingTokens,
    long retryAfterMillis
) {}
