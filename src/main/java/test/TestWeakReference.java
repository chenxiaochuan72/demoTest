package test;

import java.lang.ref.WeakReference;

/**
 * @Author: cxc
 * @CreateTime: 2023-04-13  14:31
 * @Description: TODO
 * @Version: 1.0
 */
public class TestWeakReference {
    public static void main(String[] args) {
        WeakReference<M> m=new WeakReference<>(new M());
        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());
        ThreadLocal<M> tl=new ThreadLocal<>();
        tl.set(new M());
        tl.remove();

    }
}
class M{
    private String name;
}
