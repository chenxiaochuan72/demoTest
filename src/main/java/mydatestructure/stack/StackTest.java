package mydatestructure.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author cxc
 * @Date 2023/9/2 2:15 PM
 * @Version 1.0
 * @Description:
 */

public class StackTest {
    private final static Logger logger = LoggerFactory.getLogger(StackTest.class);
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        deque.push(4);
        deque.push(5);
        deque.push(6);
        deque.push(7);
        logger.info("弹出元素：{}", deque.pop());
        logger.info("弹出元素：{}", deque.pop());
        logger.info("弹出元素：{}", deque.pop());
        logger.info("弹出元素：{}", deque.pop());
        logger.info("弹出元素：{}", deque.pop());
        logger.info("弹出元素：{}", deque.pop());
    }
}
