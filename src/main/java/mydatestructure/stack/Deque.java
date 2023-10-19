package mydatestructure.stack;

/**
 * @Author cxc
 * @Date 2023/9/2 12:16 PM
 * @Version 1.0
 * @Description:
 */

public interface Deque<E> {
    void push(E e);
    E pop();
    boolean isEmpey();
}
