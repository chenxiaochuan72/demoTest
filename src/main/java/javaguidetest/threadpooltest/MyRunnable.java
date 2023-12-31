package javaguidetest.threadpooltest;

import java.util.Date;

/**
 * @Author cxc
 * @Date 2023/7/2 2:16 PM
 * @Version 1.0
 * @Description:
 */

public class MyRunnable implements Runnable{
    private String command;

    public MyRunnable(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
