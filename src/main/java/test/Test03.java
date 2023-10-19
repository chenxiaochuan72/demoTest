package test;

public class Test03 {
    public static void main(String[] args) {
//        char a='a';
//        char b='b';
//        System.out.println((int) 'A');
//        System.out.println(a);
//        B.test();
//
        InterfaceTest c=new C();
        System.out.println(c.test());
        System.out.println(C.a);
    }
}
class A{
    public static int test(){
        return 1;
    }
}
class B extends A{
    public static   int test(){
        return 1;
    }
    public int tes2(){
        return 2;
    }
}

interface InterfaceTest{
    default int test(){
        return 1;
    }
    public
    static final int a=2;
}
class C implements InterfaceTest{
    @Override
    public int test() {
        return InterfaceTest.super.test();
    }
}
abstract class D{
    public void test(){
        System.out.println(1);
    }
}