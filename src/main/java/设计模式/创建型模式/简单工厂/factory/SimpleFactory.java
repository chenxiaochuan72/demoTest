package 设计模式.创建型模式.简单工厂.factory;

import 设计模式.创建型模式.简单工厂.service.KeyBoard;
import 设计模式.创建型模式.简单工厂.service.impl.DellKeyBoard;
import 设计模式.创建型模式.简单工厂.service.impl.HPKeyBoard;

public class SimpleFactory {
    public KeyBoard createKeyBord(String keyName){
        if ("HP".equals(keyName)){
            return new HPKeyBoard();
        }else if ("Dell".equals(keyName)){
            return new DellKeyBoard();
        }
        return null;
    }
}
