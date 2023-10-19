package 设计模式.创建型模式.建造者模式.design;

import 设计模式.创建型模式.建造者模式.design00.design.Matter;

public interface IMenu {
    IMenu appendCeiling(Matter matter);  //吊顶
    IMenu appendCoat(Matter matter); // 涂料
    IMenu appendFloor(Matter matter); // 地板
    IMenu appendTime(Matter matter); // 地砖

    String getDetail(); //明细
}
