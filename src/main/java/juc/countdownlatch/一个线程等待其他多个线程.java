package juc.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author cxc
 * @Date 2023/6/3 5:11 PM
 * @Version 1.0
 * @Description:
 */

public class 一个线程等待其他多个线程 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch=new CountDownLatch(5);

        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i=0;i<5;i++){
            final int no=i+1;
            Runnable runnable=new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long) (Math.random()*1000));
                        System.out.println(no + "号运动员完成了比赛。");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }finally {
                        latch.countDown();
                    }
                }
            };
            service.submit(runnable);
        }

        System.out.println("等待5个运动员都跑完.....");

        latch.await();

        System.out.println("所有人都跑完了，比赛结束。");
    }
}
