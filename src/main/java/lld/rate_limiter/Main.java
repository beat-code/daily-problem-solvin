package lld.rate_limiter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException{
        final int MAX_REQUESTS_PER_SEC = 10;

        RateLimiter rateLimiter = null;

        Thread requestThread = new Thread(() -> {
            sendRequest(rateLimiter, 10, 1);
            sendRequest(rateLimiter, 20, 2);
            sendRequest(rateLimiter, 50, 5);
            sendRequest(rateLimiter, 100, 10);
            sendRequest(rateLimiter, 200, 20);
            sendRequest(rateLimiter, 250, 25);
            sendRequest(rateLimiter, 500, 50);
            sendRequest(rateLimiter, 1000, 100);
        });

        requestThread.start();
        requestThread.join();
    }

    private static void sendRequest(RateLimiter rateLimiter, int totalCount, int requestPerSec){
        long startTime = System.currentTimeMillis();
        CountDownLatch latch = new CountDownLatch(totalCount);
        for(int i=0; i<totalCount; i++){
            try{
                new Thread(() -> {
                    while (!rateLimiter.allow()){
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    latch.countDown();
                }).start();
                TimeUnit.MILLISECONDS.sleep(1000/requestPerSec);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        try {
            latch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        double duration = (System.currentTimeMillis() - startTime)/1000.0;
        System.out.println(totalCount + " request processed in " + duration + " seconds. " +
                "Rate: " + (double)totalCount/duration + " per second.");
    }

}
