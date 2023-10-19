package juc;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: cxc
 * @CreateTime: 2023-04-15  15:38
 * @Description: TODO
 * @Version: 1.0
 */
public class CountDownLatchTest {
    static CountDownLatch c=new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                c.countDown();
            }
        },"thread1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(2);
                c.countDown();
            }
        },"thread2").start();

        c.await();
        System.out.println("3");
    }
}
