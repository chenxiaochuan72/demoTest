package 设计模式.行为型模式.观察者模式.user;

import 设计模式.行为型模式.观察者模式.visitor.Visitor;

/**
 * @Author cxc
 * @Date 2023/3/30 11:12 PM
 * @Version 1.0
 */
public abstract class User {
    public String name; // 姓名
    public String identity; // 身份；重点班、普通班 | 特级教师、普通教师、实习教师
    public String clazz; // 班级
    public User(String name, String identity, String clazz) {
        this.name = name;
        this.identity = identity;
        this.clazz = clazz;
    }
    // 核⼼访问⽅法
    public abstract void accept(Visitor visitor);
}
