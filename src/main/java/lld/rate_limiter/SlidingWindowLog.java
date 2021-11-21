package lld.rate_limiter;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowLog extends RateLimiter {

    private final Queue<Long> log = new LinkedList<>();
    protected SlidingWindowLog(int maxRequestsPerSec) {
        super(maxRequestsPerSec);
    }

    @Override
    boolean allow() {
        long currTime = System.currentTimeMillis();
        long boundary = currTime - 1000;

        synchronized (this){
            while(!log.isEmpty() && log.poll() <= boundary) log.poll();
            log.offer(currTime);
            return log.size() <= maxRequestsPerSec;
        }
    }
}
