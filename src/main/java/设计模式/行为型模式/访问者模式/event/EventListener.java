package 设计模式.行为型模式.访问者模式.event;

import 设计模式.行为型模式.访问者模式.LotteryResult;

/**
 * @Author cxc
 * @Date 2023/3/30 11:42 PM
 * @Version 1.0 事件监听接⼝定义
 */
public interface EventListener {
    void doEvent(LotteryResult lotteryResult);
}
