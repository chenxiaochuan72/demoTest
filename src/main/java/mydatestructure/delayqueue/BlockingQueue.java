package mydatestructure.delayqueue;

/**
 * @Author cxc
 * @Date 2023/8/30 3:32 PM
 * @Version 1.0
 * @Description:
 */

public interface BlockingQueue<E> extends Queue<E>{
    boolean add(E e);
    boolean offer(E e);
}
