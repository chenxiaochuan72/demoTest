package juc;

/**
 * @Author cxc
 * @Date 2023/7/3 10:17 AM
 * @Version 1.0
 * @Description:
 */

public class 循环打印AB {
    private boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        循环打印AB ab = new 循环打印AB();
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i=0;i<50;i++) {
                    ab.printA();
                }
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<50;i++) {

                    ab.printB();
                }
            }
        });
        thread.start();
        thread1.start();

//        thread1.join();
//        thread.join();
        System.out.println("结束");


//        Thread a = new Thread();
//        Thread b = new Thread(new MyPrintTask("B"), "b");
//        a.start();
//        b.start();
//
//
//        a.join();
//        b.join();
//        System.out.println("结束");

    }

    private synchronized void printA() {
        while (!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        flag=false;
        System.out.println("A");
        notifyAll();
    }
    private synchronized void printB() {
        while (flag){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        flag=true;
        System.out.println("B");
        notifyAll();
    }




}

class MyPrintTask implements Runnable {
    private static final Object lock = new Object();
    private static volatile int count = 0;
    private String message;

    public MyPrintTask(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (lock) {
                while (count % 2 == 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(message + ":" + count);
                count++;
                lock.notifyAll();
            }
        }
    }
}
