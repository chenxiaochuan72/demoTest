package 设计模式.行为型模式.观察者模式;

import 设计模式.行为型模式.观察者模式.user.User;
import 设计模式.行为型模式.观察者模式.user.impl.Student;
import 设计模式.行为型模式.观察者模式.user.impl.Teacher;
import 设计模式.行为型模式.观察者模式.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cxc
 * @Date 2023/3/30 11:20 PM
 * @Version 1.0
 */
public class DataView {
    List<User> userList=new ArrayList<>();
    public DataView() {
        userList.add(new Student("谢⻜机", "᯿点班", "⼀年⼀班"));
        userList.add(new Student("windy", "᯿点班", "⼀年⼀班"));
        userList.add(new Student("⼤⽑", "普通班", "⼆年三班"));

        userList.add(new Student("Shing", "普通班", "三年四班"));
        userList.add(new Teacher("BK", "特级教师", "⼀年⼀班"));
        userList.add(new Teacher("娜娜Goddess", "特级教师", "⼀年⼀班"));
        userList.add(new Teacher("dangdang", "普通教师", "⼆年三班"));
        userList.add(new Teacher("泽东", "实习教师", "三年四班"));
    }
    // 展示
    public void show(Visitor visitor) {
        for (User user : userList) {
            user.accept(visitor);
        }
    }
}
