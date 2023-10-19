package juc.completableFutureest;

/**
 * @Author cxc
 * @Date 2023/6/3 9:16 PM
 * @Version 1.0
 * @Description:
 */

public class UserInfoService {

    public String getUserInfo(Long userId) throws InterruptedException {
        Thread.sleep(300);//模拟调用耗时
        return "666 "+" ITxiaodongbei "+"27"; //一般是查数据库，或者远程调用返回的
    }
}


