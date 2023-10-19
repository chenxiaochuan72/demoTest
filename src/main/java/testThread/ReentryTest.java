package testThread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author cxc
 * @Date 2023/6/24 3:52 PM
 * @Version 1.0
 * @Description:
 */

public class ReentryTest extends A{
    public synchronized void doA() {
        System.out.println("子类方法：ReentryTest.doA() ThreadId：" + Thread.currentThread().getId());
        doB();
    }

    private synchronized void doB() {
        super.doA();
        System.out.println("子类方法：ReentryTest.doB() ThreadId：" + Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        ReentryTest reentryTest = new ReentryTest();
        reentryTest.doA();
        new ReentrantLock();
    }
}

class A{
    public synchronized void doA(){
        System.out.println("父类方法：A.doA() ThreadId：" + Thread.currentThread().getId());
    }
}
