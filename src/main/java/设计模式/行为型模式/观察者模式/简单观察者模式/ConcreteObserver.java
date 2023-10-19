package 设计模式.行为型模式.观察者模式.简单观察者模式;

/**
 * @Author cxc
 * @Date 2023/7/28 3:08 PM
 * @Version 1.0
 * @Description: 观察者接口
 */

public class ConcreteObserver implements Observer{
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }
    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}
