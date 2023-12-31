package juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author: cxc
 * @CreateTime: 2023-04-13  23:54
 * @Description: TODO
 * @Version: 1.0
 */
public class TwinsLock implements Lock {
    public static final class Sync extends AbstractQueuedSynchronizer{
        Sync(int count){
            if (count<=0){
                throw new IllegalArgumentException("count must large\n" +
                        "than zero");
            }
            setState(count);
        }

        @Override
        protected int tryAcquireShared(int arg) {
            for (;;){
                int current=getState();
                int newCount=current-arg;
                if (newCount<0||compareAndSetState(current,newCount)){
                    return newCount;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            for (;;){
                int current=getState();
                int newCount=current+arg;
                if (compareAndSetState(current,newCount)){
                    return true;
                }
            }
        }
    }

    private Sync sync=new Sync(2);

    @Override
    public void lock() {
        sync.tryAcquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.tryReleaseShared(1);
    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
class TestWorker{
    public static void main(String[] args) throws InterruptedException {
        Lock lock=new TwinsLock();
        class worker extends Thread{
            @Override
            public void run() {
                while (true){
                    lock.lock();
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }
        for (int i=0;i<10;i++){
            worker worker=new worker();
            worker.setDaemon(true);
            worker.start();
        }
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println();
        }
    }
}