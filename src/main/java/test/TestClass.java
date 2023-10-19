package test;

/**
 * @Author cxc
 * @Date 2023/6/26 7:57 PM
 * @Version 1.0
 * @Description:
 */

public class TestClass {
    public static void main(String[] args) {
        A1 ab = new B1();
        ab = new B1();
    }
}

class A1 {
    static {
        System.out.print("1");
    }

    public A1() {
        System.out.print("2");
    }
}

class B1 extends A1 {
    static {
        System.out.print("a");
    }

    public B1() {
        System.out.print("b");
    }
}

