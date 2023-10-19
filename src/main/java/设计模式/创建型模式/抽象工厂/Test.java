package 设计模式.创建型模式.抽象工厂;

import 设计模式.创建型模式.抽象工厂.factory.DellFactory;
import 设计模式.创建型模式.抽象工厂.factory.HPFactory;
import 设计模式.创建型模式.抽象工厂.factory.IFactory;
import 设计模式.创建型模式.抽象工厂.service.Keyboard;

public class Test {
    public static void main(String[] args) {
        IFactory dellFactory = new DellFactory();
        IFactory hpFactory=new HPFactory();

        Keyboard keyboard = dellFactory.createKeyboard();
        keyboard.print();

    }
}
