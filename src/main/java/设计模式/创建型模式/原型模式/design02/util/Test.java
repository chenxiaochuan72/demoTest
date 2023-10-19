package 设计模式.创建型模式.原型模式.design02.util;

import 设计模式.创建型模式.原型模式.design02.QuestionBankController;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        QuestionBankController questionBankController=new QuestionBankController();
        System.out.println(questionBankController.createPaper("cxc","22222"));
    }
}
