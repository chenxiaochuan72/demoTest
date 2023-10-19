package 设计模式.行为型模式.观察者模式.visitor.impl;

import lombok.extern.slf4j.Slf4j;
import 设计模式.行为型模式.观察者模式.user.impl.Student;
import 设计模式.行为型模式.观察者模式.user.impl.Teacher;
import 设计模式.行为型模式.观察者模式.visitor.Visitor;

/**
 * @Author cxc
 * @Date 2023/3/30 11:13 PM
 * @Version 1.0
 */
@Slf4j
public class Principal implements Visitor {

    @Override
    public void visit(Student student) {
        log.info("学⽣信息 姓名：{} 班级：{}", student.name, student.clazz);
    }

    @Override
    public void visit(Teacher teacher) {
        log.info("学⽣信息 姓名：{} 班级：{} 升学率：{}", teacher.name, teacher.clazz, teacher.entranceRatio());
    }
}
