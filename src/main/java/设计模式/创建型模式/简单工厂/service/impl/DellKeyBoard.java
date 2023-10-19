package 设计模式.创建型模式.简单工厂.service.impl;

import 设计模式.创建型模式.简单工厂.service.KeyBoard;

public class DellKeyBoard implements KeyBoard {
    @Override
    public void print() {
        System.out.println("戴尔键盘");
    }
}
