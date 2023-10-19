package 设计模式.结构型模式.享元模式;

import 设计模式.结构型模式.享元模式.util.RedisUtils;

public class ActivityController {
    private RedisUtils redisUtils = new RedisUtils();

    public Activity queryActivityInfo(Long id){
        Activity activicy = ActivityFactory.getActivicy(id);

        Stock stock = new Stock(1000, redisUtils.getStockUsed());
        activicy.setStock(stock);
        return activicy;
    }
}
