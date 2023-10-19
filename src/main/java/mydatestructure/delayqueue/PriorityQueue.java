package mydatestructure.delayqueue;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @Author cxc
 * @Date 2023/8/31 2:25 PM
 * @Version 1.0
 * @Description: 平衡二叉堆结构
 *  父子节点索引关系：  假如父节点为 queue[n]，那么左子节点为 queue[2n+1]，右子节点为 queue[2n+2]  任意孩子节点的父节点位置，都是 n-1>>>1 相当于除 2 取整
 *  节点间大小关系：  父节点小于等于任意孩子节点  同一层级的两个孩子节点大小不需要维护，它是在弹出元素的时候进行判断 的
 *  子叶节点与非子叶节点：  一个长度为 size 的优先级队列，当 index >= size >>> 1 时，该节点为 叶子节点。否则，为非叶子节点。
 */

public class PriorityQueue<E> implements Queue<E> {
    private Logger logger = LoggerFactory.getLogger(PriorityQueue.class);

    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    transient Object[] queue;

    private int size = 0;

    public PriorityQueue() {
        queue = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    @Override
    public boolean add(E e) {
        return offer(e);
    }

    @Override
    public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();
        int i = size;
        if (i >= queue.length) {
            grow(i + 1);
        }
        size = i + 1;
        if (i == 0) {
            queue[0] = e;
        } else {
            siftUp(i, e);
        }
        return true;
    }

    private void siftUp(int k, E x) {
        siftUpComparable(k, x);
    }

    @SuppressWarnings("unchecked")
    private void siftUpComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>) x;
        logger.info("【入队】元素: {} 当前队列{}", JSON.toJSONString(key), JSON.toJSONString(queue));
        while (k > 0) {
            // 获取父节点Idx,相当于除以2
            int parent = (k - 1) >>> 1;
            logger.info("【入队】寻找当前节点的父节点位置。k：{} parent：{}", k, parent);
            Object e = queue[parent];
            // 如果当前位置元素,大于父节点元素,则退出循环
            if (key.compareTo((E) e) >= 0) {
                logger.info("【入队】值比对，父节点：{} 目标节点：{}", JSON.toJSONString(e), JSON.toJSONString(key));
                break;
            }
            // 相反父节点位置大于当前位置元素,则进行替换
            logger.info("【入队】替换过程，父子节点位置替换，继续循环。父节点值：{} 存放到位置：{}", JSON.toJSONString(e), k);
            queue[k] = e;
            k = parent;
        }
        queue[k] = key;
        logger.info("【入队】完成 Idx：{} Val：{} \r\n当前队列：{} \r\n", k, JSON.toJSONString(key), JSON.toJSONString(queue));
    }

    private void grow(int minCapacity) {
        int oldCapacity = queue.length;
        int newCapacity = oldCapacity + (oldCapacity < 64 ? (oldCapacity + 2) : (oldCapacity >> 2));
        if (newCapacity - (Integer.MAX_VALUE - 8) > 0) {
            newCapacity = (minCapacity > (Integer.MAX_VALUE - 8) ? Integer.MAX_VALUE : Integer.MAX_VALUE - 8);
        }
        queue = Arrays.copyOf(queue, newCapacity);
    }

    /**
     * 根元素直接删除弹出,然后寻找最小的元素迁移到队头
     *
     * @return
     */
    @Override
    public E poll() {
        if (size == 0) {
            return null;
        }
        int s = --size;
        E result = (E) queue[0];
        //获得队尾元素
        E x = (E) queue[s];
        queue[s] = null;
        if (s != 0) {
            siftDown(0, x);
        }
        return result;
    }

    private void siftDown(int k, E x) {
        siftDownComparable(k, x);
    }

    @SuppressWarnings("unchecked")
    private void siftDownComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>) x;
        // 找出中间节点
        int half = size >>> 1;
        // k<half表示编号为k的节点有孩子节点，没有孩子节点，就不需要找了
        while (k < half) {
            // 找到左子节点和右子节点,俩个节点进行比较,找出最大的值
            int child = (k << 1) + 1;
            Object c = queue[child];
            int right = child + 1;
            // 左子节点与右子节点比较，取最小的节点(此处比较先默认左边的值最小,然后和右边的值做比较,
            // 如果左子节点得值比右子节点的值)
            if (right < size && ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0) {
                logger.info("【出队】左右子节点比对，获取最小值。left：{} right：{}", JSON.toJSONString(c), JSON.toJSONString(queue[right]));
                c = queue[child = right];
            }
            // 目标值与c比较,当目标值小于c值,退出循环.说明此时目标值所在位置适合,迁移完成
            if (key.compareTo((E) c) <= 0) {
                break;
            }
            // 目标大于于c值，位置替换，继续比较
            logger.info("【出队】替换过程，节点的值比对。上节点：{} 下节点：{} 位置替换", JSON.toJSONString(queue[k]), JSON.toJSONString(c));
            queue[k] = c;
            k = child;
        }
        // 把目标值放到对应位置
        logger.info("【出队】替换结果，最终更换位置。Idx：{} Val：{}", k, JSON.toJSONString(key));
        queue[k] = key;
    }

    @Override
    public E peek() {
        return (size == 0) ? null : (E) queue[0];
    }
}
