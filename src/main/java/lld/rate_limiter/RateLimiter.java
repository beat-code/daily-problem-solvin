package lld.rate_limiter;

public abstract class RateLimiter {
    protected final int maxRequestsPerSec;

    protected RateLimiter(int maxRequestsPerSec){
        this.maxRequestsPerSec = maxRequestsPerSec;
    }

    abstract boolean allow();
}
