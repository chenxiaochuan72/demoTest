package 设计模式.创建型模式.建造者模式.design;

import 设计模式.创建型模式.建造者模式.design00.design.ceiling.LevelTwoCeiling;
import 设计模式.创建型模式.建造者模式.design00.design.coat.DuluxCoat;
import 设计模式.创建型模式.建造者模式.design00.design.floor.ShengXiangFloor;

import java.math.BigDecimal;

public class Builder {
    public IMenu levelOne(Double area){
        return new DecorationPackageMenu(new BigDecimal(area),"豪华欧式")
                .appendCeiling(new LevelTwoCeiling())
                .appendCoat(new DuluxCoat())
                .appendFloor(new ShengXiangFloor());
    }
}
