package 设计模式.行为型模式.观察者模式.user.impl;

import 设计模式.行为型模式.观察者模式.user.User;
import 设计模式.行为型模式.观察者模式.visitor.Visitor;

/**
 * @Author cxc
 * @Date 2023/3/30 11:12 PM
 * @Version 1.0
 */
public class Student extends User {
    public Student(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public int ranking() {
        return (int) (Math.random() * 100);
    }
}
