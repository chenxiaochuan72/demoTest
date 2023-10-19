package mydatestructure.delayqueue;

/**
 * @Author cxc
 * @Date 2023/8/30 3:26 PM
 * @Version 1.0
 * @Description: Java泛型中的标记符含义：
 *  * E - Element （元素,在集合中使用）
 *  * T - Type （Java类）
 *  * K - Key （键）
 *  * V - Value （值）
 *  * N - Number（数值类型）
 *  * ? - 表示不确定的Java类型
 */

public interface Queue<E> {
    /**
     * 将指定的元素插入到此队列中，
     * @param e
     * @return
     */
    boolean add(E e);

    /**
     * 如果在不违反容量限制的情况下立即执行，则将指定的元素插入到此队列中。
     * @param e
     * @return
     */
    boolean offer(E e);

    /**
     * 检索并删除此队列的头，如果此队列为空，则返回 null 。
     * @return
     */
    E poll();

    /**
     * 检索但不删除此队列的头，如果此队列为空，则返回 null 。
     * @return
     */
    E peek();
}
