package 设计模式.行为型模式.观察者模式.简单观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cxc
 * @Date 2023/7/28 3:05 PM
 * @Version 1.0
 * @Description: 主题
 */

public class Subject {
    List<Observer> observers=new ArrayList<>();
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
