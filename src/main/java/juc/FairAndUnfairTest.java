package juc;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: cxc
 * @CreateTime: 2023-04-14  15:45
 * @Description: TODO
 * @Version: 1.0
 */
@Slf4j
public class FairAndUnfairTest {
    private static ReentrantLock2 fairLock=new ReentrantLock2(true);
    private static ReentrantLock2 unfairLock=new ReentrantLock2(false);

    public static void main(String[] args) {
        for (int i=0;i<10;i++){

            new Thread(new Job(fairLock),i+":").start();
        }
    }
    private static class Job extends Thread{
        private ReentrantLock2 lock;

        public Job(ReentrantLock2 lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            log.info(Thread.currentThread().getName());
            log.info(lock.getQueuedThreads().toString());
        }
    }

    private static class ReentrantLock2 extends ReentrantLock{
        public ReentrantLock2(boolean fair){
            super(fair);
        }
        @Override
        public Collection<Thread> getQueuedThreads(){
            List<Thread> arrayList=new ArrayList<>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }
}
