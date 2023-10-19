package juc;

import java.util.concurrent.TimeUnit;

/**
 * @Author: cxc
 * @CreateTime: 2023-04-13  21:12
 * @Description: TODO
 * @Version: 1.0
 */
public class Join {
    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        for(int i=0;i<10;i++){
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous=thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " terminate.");

    }
    static class Domino implements Runnable{
        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }
}
