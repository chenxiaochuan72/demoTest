package mydatestructure.delayqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * @Author cxc
 * @Date 2023/8/31 4:32 PM
 * @Version 1.0
 * @Description: 延迟队列
 */

public class DelayQueue<E extends Delayed> implements BlockingQueue<E> {
    private final transient ReentrantLock lock=new ReentrantLock();
    private final PriorityQueue<E> q = new PriorityQueue<>();
    private final Condition available=lock.newCondition();
    @Override
    public boolean add(E e) {
        return offer(e);
    }

    @Override
    public boolean offer(E e) {
        final ReentrantLock lock=this.lock;
        lock.lock();
        try {
            q.offer(e);
            if (q.peek()==e){
                available.signal();
            }
            return true;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E poll() {
        final ReentrantLock lock=this.lock;
        lock.lock();
        try {
            E first = q.peek();
            if (first==null||first.getDelay(NANOSECONDS)>0){
                return null;
            }else {
                return q.poll();
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E peek() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return q.peek();
        } finally {
            lock.unlock();
        }
    }
}
