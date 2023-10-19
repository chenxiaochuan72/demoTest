package 设计模式.行为型模式.观察者模式.visitor;

import 设计模式.行为型模式.观察者模式.user.impl.Student;
import 设计模式.行为型模式.观察者模式.user.impl.Teacher;

/**
 * @Author cxc
 * @Date 2023/3/30 11:13 PM
 * @Version 1.0
 */
public interface Visitor {
    // 访问学⽣信息
    void visit(Student student);
    // 访问⽼师信息
    void visit(Teacher teacher);
}
