package 设计模式.创建型模式.工厂模式.factory;


import 设计模式.创建型模式.工厂模式.service.KeyBoard;
import 设计模式.创建型模式.工厂模式.service.impl.DellKeyBoard;

public class DellFactory implements IFctory {
    @Override
    public KeyBoard createKeyBoard() {
        return new DellKeyBoard();
    }
}
