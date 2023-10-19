package 设计模式.创建型模式.建造者模式.design;

public class Test {
    public static void main(String[] args) {
        Builder builder=new Builder();
        System.out.println(builder.levelOne(123D).getDetail());
    }
}
