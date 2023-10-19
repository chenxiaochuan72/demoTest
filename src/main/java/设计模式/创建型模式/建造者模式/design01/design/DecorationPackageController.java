package 设计模式.创建型模式.建造者模式.design01.design;

import 设计模式.创建型模式.建造者模式.design00.design.Matter;
import 设计模式.创建型模式.建造者模式.design00.design.ceiling.LevelTwoCeiling;
import 设计模式.创建型模式.建造者模式.design00.design.coat.DuluxCoat;
import 设计模式.创建型模式.建造者模式.design00.design.floor.ShengXiangFloor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DecorationPackageController {
    public String getMatterList(BigDecimal area,Integer level){
        List<Matter> list=new ArrayList<>();// 装修清淡
        BigDecimal price=BigDecimal.ZERO; //价格

        if (level==1){
            LevelTwoCeiling levelTwoCeiling=new LevelTwoCeiling();
            DuluxCoat duluxCoat=new DuluxCoat();
            ShengXiangFloor shengXiangFloor=new ShengXiangFloor();

            list.add(levelTwoCeiling);
            list.add( duluxCoat);
            list.add( shengXiangFloor);

            price=price.add(area.multiply(new BigDecimal("0.2")).multiply(levelTwoCeiling.price()));
            price=price.add(area.multiply(new BigDecimal("0.2")).multiply(duluxCoat.price()));
            price=price.add(area.multiply(new BigDecimal("0.2")).multiply(shengXiangFloor.price()));

        }
        StringBuilder detail=new StringBuilder("\r\n--------------\r\n"+
                "装修清单" + "\r\n" +
                "套餐等级：" + level + "\r\n" +
                "套餐价格：" + price.setScale(2, BigDecimal.ROUND_HALF_UP) + " 元\r\n" +
                "房屋面积：" + area.doubleValue() + " 平米\r\n" +
                "材料清单：\r\n");

        for (Matter matter:list){
            detail.append(matter.scene()).append("：").append(matter.brand()).append("、").append(matter.model()).append("、平米价格：").append(matter.price()).append(" 元。\n");
        }
        return detail.toString();
    }
}
