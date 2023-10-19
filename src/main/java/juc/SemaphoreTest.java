package juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author: cxc
 * @CreateTime: 2023-04-15  15:47
 * @Description: TODO
 * @Version: 1.0
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT=30;
    private static ExecutorService threadPool=Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s=new Semaphore(5);

    public static void main(String[] args) {
//        for (int i=0;i<THREAD_COUNT;i++){
//            threadPool.execute(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        s.acquire();
//                        Thread.sleep(5000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    System.out.println("sava data");
//                    s.release();
//                }
//            });
//        }
//        threadPool.shutdown();
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
