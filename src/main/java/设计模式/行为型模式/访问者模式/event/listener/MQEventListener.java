package 设计模式.行为型模式.访问者模式.event.listener;

import lombok.extern.slf4j.Slf4j;
import 设计模式.行为型模式.访问者模式.LotteryResult;
import 设计模式.行为型模式.访问者模式.event.EventListener;

/**
 * @Author cxc
 * @Date 2023/3/30 11:45 PM
 * @Version 1.0
 */
@Slf4j
public class MQEventListener implements EventListener {
    @Override
    public void doEvent(LotteryResult result) {
        log.info("记录⽤户 {} 摇号结果(MQ)：{}", result.getuId(), result.getMsg());
    }
}
