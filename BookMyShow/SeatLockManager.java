package BookMyShow;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SeatLockManager {
    
    public final Map<String, Long> lockedSeats =
          new ConcurrentHashMap<>();

    private final long lockDurationMillis;

    public SeatLockManager(long lockDurationMillis){
        this.lockDurationMillis = lockDurationMillis;
    }

    public boolean lock(String seatId){

        long now = System.currentTimeMillis();

        Long existingLock = lockedSeats.get(seatId);

        if(existingLock != null && now-existingLock < lockDurationMillis){
            return false;
        }

        lockedSeats.put(seatId, now);

        return true;
    }

    public void unlock(String seatId){
        lockedSeats.remove(seatId);
    }

}
