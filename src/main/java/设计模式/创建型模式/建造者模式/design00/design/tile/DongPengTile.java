package 设计模式.创建型模式.建造者模式.design00.design.tile;


import 设计模式.创建型模式.建造者模式.design00.design.Matter;

import java.math.BigDecimal;

/**
 * 地砖
 * 品牌：东鹏瓷砖
 */
public class DongPengTile implements Matter {

    public String scene() {
        return "地砖";
    }

    public String brand() {
        return "东鹏瓷砖";
    }

    public String model() {
        return "10001";
    }

    public BigDecimal price() {
        return new BigDecimal(102);
    }

    public String desc() {
        return "东鹏瓷砖以品质铸就品牌，科技推动品牌，口碑传播品牌为宗旨，2014年品牌价值132.35亿元，位列建陶行业榜首。";
    }

}