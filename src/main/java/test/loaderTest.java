package test;

import sun.jvm.hotspot.HelloWorld;

public class loaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = HelloWorld.class.getClassLoader();

        System.out.println(classLoader);

        classLoader.loadClass("test.Test2");
        Class.forName("test.Test2");
    }
}

