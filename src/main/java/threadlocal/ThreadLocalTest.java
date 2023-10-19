package threadlocal;

import java.util.concurrent.Executors;

public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal=new ThreadLocal<>();
        Executors.newFixedThreadPool(4);
        threadLocal.set("22");
        threadLocal.set("333");;
        System.out.println(threadLocal.get());
    }
}
