package 范型;

/**
 * @Author cxc
 * @Date 2023/5/30 11:27 PM
 * @Version 1.0
 * @Description:
 */

public class test1 {
    public static void main(String[] args) {
        Demo1<String> objectDemo1 = new Demo1<>();
        objectDemo1.setEle1("2");
        objectDemo1.setEle2("3");
        System.out.println(objectDemo1.getEle1());


        Integer met = objectDemo1.met(22);
        System.out.println(met);
    }
}
