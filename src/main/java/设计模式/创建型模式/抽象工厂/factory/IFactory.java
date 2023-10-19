package 设计模式.创建型模式.抽象工厂.factory;


import 设计模式.创建型模式.抽象工厂.service.Keyboard;
import 设计模式.创建型模式.抽象工厂.service.MainFrame;
import 设计模式.创建型模式.抽象工厂.service.Monitor;

public interface IFactory {
    MainFrame createMainFrame();
    Monitor createMonitor();
    Keyboard createKeyboard();
}
