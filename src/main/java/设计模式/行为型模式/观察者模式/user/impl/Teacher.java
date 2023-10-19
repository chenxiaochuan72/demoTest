package 设计模式.行为型模式.观察者模式.user.impl;

import 设计模式.行为型模式.观察者模式.user.User;
import 设计模式.行为型模式.观察者模式.visitor.Visitor;

import java.math.BigDecimal;

/**
 * @Author cxc
 * @Date 2023/3/30 11:12 PM
 * @Version 1.0
 */
public class Teacher extends User {

    public Teacher(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    // 升本率
    public double entranceRatio() {
        return BigDecimal.valueOf(Math.random() * 100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
