package javaguidetest.threadpooltest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cxc
 * @Date 2023/7/2 5:33 PM
 * @Version 1.0
 * @Description:
 */

public class ThreadLocalTest {
    private List<String> messages = new ArrayList();
    public static final ThreadLocal<ThreadLocalTest> holder = ThreadLocal.withInitial(ThreadLocalTest::new);

    public static void add(String message) {
        holder.get().messages.add(message);
    }
    public static List<String> clear() {
        List<String> messages = holder.get().messages;
        holder.remove();

        System.out.println("size: " + holder.get().messages.size());
        return messages;
    }

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

    }


}
