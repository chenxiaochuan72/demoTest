package 设计模式.创建型模式.建造者模式.design01;

import 设计模式.创建型模式.建造者模式.design01.design.DecorationPackageController;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        DecorationPackageController decoration = new DecorationPackageController();

        // 豪华欧式
        System.out.println(decoration.getMatterList(new BigDecimal("132.52"),1));
    }
}
