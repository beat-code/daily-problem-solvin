package lld.rate_limiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SlidingWindow extends RateLimiter{

    private ConcurrentMap<Long, AtomicInteger> windows = new ConcurrentHashMap<>();

    protected SlidingWindow(int maxRequestsPerSec) {
        super(maxRequestsPerSec);
    }

    @Override
    boolean allow() {
        long currTime = System.currentTimeMillis();
        long currWindowKey = currTime/1000*1000;
        windows.putIfAbsent(currWindowKey, new AtomicInteger(0));
        long prevWindowKey = currWindowKey-1000;
        AtomicInteger prevCount = windows.get(prevWindowKey);
        if(prevCount==null) {
            return windows.get(currWindowKey).incrementAndGet() <= maxRequestsPerSec;
        }

        double prevWeight = 1 - (currTime-currWindowKey)/1000.0;
        long count = (long) (prevCount.get()*prevWeight + windows.get(currWindowKey).incrementAndGet());
        return count <= maxRequestsPerSec;
    }
}
