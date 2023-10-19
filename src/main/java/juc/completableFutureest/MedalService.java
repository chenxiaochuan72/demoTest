package juc.completableFutureest;

/**
 * @Author cxc
 * @Date 2023/6/3 9:17 PM
 * @Version 1.0
 * @Description:
 */

public class MedalService {

    public String getMedalInfo(long userId) throws InterruptedException {
        Thread.sleep(500); //模拟调用耗时
        return "666"+"守护勋章";
    }
}
