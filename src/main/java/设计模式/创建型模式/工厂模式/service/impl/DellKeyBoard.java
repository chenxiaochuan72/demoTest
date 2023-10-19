package 设计模式.创建型模式.工厂模式.service.impl;


import 设计模式.创建型模式.工厂模式.service.KeyBoard;

public class DellKeyBoard implements KeyBoard {
    @Override
    public void print() {
        System.out.println("戴尔键盘");
    }
}
