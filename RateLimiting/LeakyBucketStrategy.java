package RateLimiting;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LeakyBucketStrategy implements RateLimitStrategy{

    private final int capacity;
    private final double leakRatePerSecond;

    private final ConcurrentMap<String, Bucket> buckets =
       new ConcurrentHashMap<>();

    public LeakyBucketStrategy(int capacity, double leakRatePerSecond) {
        if (capacity <= 0 || leakRatePerSecond <= 0) {
            throw new IllegalArgumentException("Capacity and leak rate must be positive");
        }

        this.capacity = capacity;
        this.leakRatePerSecond = leakRatePerSecond;
    }

    @Override
    public RateLimitResult tryConsume(String key) {
        Bucket bucket = buckets.computeIfAbsent(key, ignored -> new Bucket(System.nanoTime()));
        return bucket.tryConsume(capacity, leakRatePerSecond);
    }


    private static class Bucket{

        private double water;
        private long lastUpdate;

        Bucket(long now){
            this.lastUpdate = now;
        }

        synchronized RateLimitResult tryConsume(int capacity,double leakRatePerSecond){

            long now = System.nanoTime();

            double elapsedSeconds = (now - lastUpdate)/1_000_000;

            water = Math.max(
                0.0, 
                water - elapsedSeconds*leakRatePerSecond
            );

            lastUpdate =  now;

            if(water + 1.0 <=capacity){

                water += 1.0;

                return new RateLimitResult(
                    true,
                    capacity-water,
                    0
                );

            }

            double requiredLeak = water - (capacity - 1.0);

            long retryMillis = (long) Math.ceil(
                requiredLeak/leakRatePerSecond*1000  
            );

            return new RateLimitResult(false, Math.max(0.0, capacity-water), retryMillis);
        }

    }

    
}
