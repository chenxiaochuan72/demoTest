package 设计模式.行为型模式.观察者模式.简单观察者模式;

/**
 * @Author cxc
 * @Date 2023/7/28 3:13 PM
 * @Version 1.0
 * @Description:
 */

public class ObserverPatternExample {
    public static void main(String[] args) {
        Subject subject=new Subject();
        Observer observer1=new ConcreteObserver("name1");
        Observer observer2=new ConcreteObserver("name2");

        subject.addObserver(observer1);
        subject.addObserver(observer2);


        subject.notifyObservers("hhelo");

    }
}
