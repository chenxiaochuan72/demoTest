package mydatestructure.delayqueue;

/**
 * @Author cxc
 * @Date 2023/8/30 3:31 PM
 * @Version 1.0
 * @Description: 双端队列接口
 */

public interface Deque<E> extends Queue<E> {
    /**
     * 插入此双端队列的前面，
     * @param e
     */
    void addFirst(E e);

    /**
     * 插入此双端队列的末尾
     * @param e
     */
    void addLast(E e);
}
