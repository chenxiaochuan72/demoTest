package 设计模式.创建型模式.简单工厂;

import 设计模式.创建型模式.简单工厂.factory.SimpleFactory;
import 设计模式.创建型模式.简单工厂.service.KeyBoard;

public class Test {
    public static void main(String[] args) {
        SimpleFactory factory=new SimpleFactory();

        // 创建戴尔键盘
        KeyBoard dell = factory.createKeyBord("Dell");
        dell.print();
        // 创建惠普键盘
        KeyBoard hp = factory.createKeyBord("HP");
        hp.print();
    }
}
