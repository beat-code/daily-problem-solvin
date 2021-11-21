package lld.rate_limiter;

import java.util.concurrent.TimeUnit;

public class TokenBucket extends RateLimiter {

    private int tokens;

    protected TokenBucket(int maxRequestsPerSec) {
        super(maxRequestsPerSec);
        this.tokens = maxRequestsPerSec;

        new Thread(() -> {
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        }).start();
    }


    @Override
    boolean allow() {
        synchronized (this){
            if(tokens==0) return false;
            tokens--;
            return true;
        }
    }

    private void refillTokens(int count){
        synchronized (this){
            tokens = Math.min(tokens + count, maxRequestsPerSec);
            notifyAll();
        }
    }
}
