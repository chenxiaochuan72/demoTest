package 设计模式.行为型模式.访问者模式;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author cxc
 * @Date 2023/3/30 11:59 PM
 * @Version 1.0
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        LotteryService lotteryService = new LotteryServiceImpl();
        LotteryResult result = lotteryService.draw("2765789109876");
        log.info("测试结果：{}", result.toString());
    }
}
