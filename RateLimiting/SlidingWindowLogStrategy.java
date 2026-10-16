package RateLimiting;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import BookMyShow.model.User;


public class SlidingWindowLogStrategy implements  RateLimitStrategy {

    private final int limit;
    private final long windowNanos;

    private final ConcurrentMap<String, UserLog> logs =
       new ConcurrentHashMap<>();

    public SlidingWindowLogStrategy(int limit, long windowMillis){
        
        if(limit <= 0 || windowMillis <= 0){
            throw new IllegalArgumentException();
        }
        
        this.limit = limit;
        this.windowNanos = windowMillis*1_000_000;
    }

    @Override
    public RateLimitResult tryConsume(String key) {
        // TODO Auto-generated method stub

        UserLog log = logs.computeIfAbsent(key, ignored -> new UserLog());

        return log.tryConsume(limit, windowNanos);
    }

    private static class UserLog {

        private final Deque<Long> timestamps = new ArrayDeque<>();

        synchronized RateLimitResult tryConsume(int limit, long windowNanos){

            long now = System.nanoTime();
            long cutOff = now - windowNanos;

            while(!timestamps.isEmpty() && timestamps.peekLast() <= cutOff){
                timestamps.removeFirst();
            }

            if(timestamps.size() < limit){

                timestamps.addLast(now);

                return new RateLimitResult(
                    true,
                    limit - timestamps.size(),
                    0
                );
            }

            long oldest = timestamps.peekFirst();

            long remainingNanos = oldest + windowNanos - now;

            long retryMillis = (remainingNanos + 999_999L)/1_000_000;

            return new RateLimitResult(
                false,
                0,
                retryMillis
            );
        }

    }
    
}
