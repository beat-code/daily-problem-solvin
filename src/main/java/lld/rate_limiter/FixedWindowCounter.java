package lld.rate_limiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowCounter extends RateLimiter {

    private final ConcurrentMap<Long, AtomicInteger> windows = new ConcurrentHashMap<>();

    protected FixedWindowCounter(int maxRequestsPerSec) {
        super(maxRequestsPerSec);
    }

    @Override
    boolean allow() {
        long windowKey = System.currentTimeMillis()/1000*1000;
        return windows.get(windowKey).incrementAndGet() <= maxRequestsPerSec;
    }
}
