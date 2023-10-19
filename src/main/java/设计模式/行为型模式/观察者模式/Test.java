package 设计模式.行为型模式.观察者模式;

import 设计模式.行为型模式.观察者模式.visitor.impl.Parent;
import 设计模式.行为型模式.观察者模式.visitor.impl.Principal;

/**
 * @Author cxc
 * @Date 2023/3/30 11:22 PM
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        DataView dataView=new DataView();
        dataView.show(new Parent());


        dataView.show(new Principal());
    }
}
