package test;

/**
 * @Author cxc
 * @Date 2023/6/25 4:54 PM
 * @Version 1.0
 * @Description:
 */

public class AutoUnboxingTest {
    public static void main(String[] args) {
//        Integer a = new Integer(3);
//        Integer b = 3; // 将 3 自动装箱成 Integer 类型
//        int c = 3;
//        System.out.println(a == b); // false 两个引用没有引用同一对象
//        System.out.println(a == c); // true a 自动拆箱成 int 类型再和 c比较
//        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
//        System.out.println(f1 == f2);
//        System.out.println(f3 == f4);
//
//        String s1 = new StringBuilder("go").append("od").toString();
//        System.out.println(s1.intern() == s1);
//        String s2 = new StringBuilder("ja").append("va").toString();
//        System.out.println(s2.intern() == s2);
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());
    }
}
interface Person{
    default String test(){
       return "hhh";
    }
    int a=2;
    static final String str="123";

}
