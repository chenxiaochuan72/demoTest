package 设计模式.创建型模式.抽象工厂.factory;

import 设计模式.创建型模式.抽象工厂.service.impl.DellKeyboard;
import 设计模式.创建型模式.抽象工厂.service.impl.DellMainFrame;
import 设计模式.创建型模式.抽象工厂.service.impl.DellMonitor;
import 设计模式.创建型模式.抽象工厂.service.Keyboard;
import 设计模式.创建型模式.抽象工厂.service.MainFrame;
import 设计模式.创建型模式.抽象工厂.service.Monitor;

public class DellFactory implements IFactory{
    @Override
    public MainFrame createMainFrame() {
        return new DellMainFrame();
    }

    @Override
    public Monitor createMonitor() {
        return new DellMonitor();
    }

    @Override
    public Keyboard createKeyboard() {
        return new DellKeyboard();
    }
}
