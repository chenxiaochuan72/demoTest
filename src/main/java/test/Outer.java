package test;

/**
 * @Author cxc
 * @Date 2023/6/26 3:10 PM
 * @Version 1.0
 * @Description:
 */

public class Outer {
    class Inner {
    }

    public static void foo() {
        new Outer().new Inner();
    }

    public void bar() {
        new Inner();
    }

    public static void main(String[] args) {
        new Outer().new Inner();
    }
}
