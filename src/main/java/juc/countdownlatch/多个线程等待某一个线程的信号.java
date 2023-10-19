package juc.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author cxc
 * @Date 2023/6/3 5:16 PM
 * @Version 1.0
 * @Description:
 */

public class 多个线程等待某一个线程的信号 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("运动员有5秒的准备时间");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i=0;i<5;i++){
            final int no=i+1;
            Runnable runnable=new Runnable() {
                @Override
                public void run() {
                    System.out.println(no + "号运动员准备完毕，等待裁判员的发令枪");
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
            service.submit(runnable);
        }
        Thread.sleep(5000);

        System.out.println("5秒准备时间已过，发令枪响，比赛开始！");

        countDownLatch.countDown();
    }
}
