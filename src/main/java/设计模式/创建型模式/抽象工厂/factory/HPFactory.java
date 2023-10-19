package 设计模式.创建型模式.抽象工厂.factory;

import 设计模式.创建型模式.抽象工厂.service.impl.HPKeyboard;
import 设计模式.创建型模式.抽象工厂.service.impl.HPMainFrame;
import 设计模式.创建型模式.抽象工厂.service.impl.HPMonitor;
import 设计模式.创建型模式.抽象工厂.service.Keyboard;
import 设计模式.创建型模式.抽象工厂.service.MainFrame;
import 设计模式.创建型模式.抽象工厂.service.Monitor;

public class HPFactory implements IFactory{
    @Override
    public MainFrame createMainFrame() {
        return new HPMainFrame();
    }

    @Override
    public Monitor createMonitor() {
        return new HPMonitor();
    }

    @Override
    public Keyboard createKeyboard() {
        return new HPKeyboard();
    }
}
