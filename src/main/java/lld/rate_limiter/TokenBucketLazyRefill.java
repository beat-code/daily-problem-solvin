package lld.rate_limiter;

public class TokenBucketLazyRefill extends RateLimiter {

    private int tokens;
    private long lastRefillTime;

    protected TokenBucketLazyRefill(int maxRequestsPerSec) {
        super(maxRequestsPerSec);
        this.tokens = maxRequestsPerSec;
        this.lastRefillTime = System.currentTimeMillis();
    }

    @Override
    boolean allow() {
        synchronized (this){
            refillTokens();
            if(tokens==0) return false;
            tokens--;
            return true;
        }
    }

    private void refillTokens() {
        long currTime = System.currentTimeMillis();
        long lastRefillTimediff = (lastRefillTime - currTime)/1000;
        int count = (int)(lastRefillTimediff*maxRequestsPerSec);
        if(count > 0){
            tokens = Math.min(tokens + count, maxRequestsPerSec);
            lastRefillTime = currTime;
        }
    }


}
