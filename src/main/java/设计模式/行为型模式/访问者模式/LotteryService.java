package 设计模式.行为型模式.访问者模式;

import 设计模式.行为型模式.访问者模式.event.listener.MQEventListener;
import 设计模式.行为型模式.访问者模式.event.listener.MessageEventListener;
import 设计模式.行为型模式.访问者模式.manager.EventManager;

/**
 * @Author cxc
 * @Date 2023/3/30 11:52 PM
 * @Version 1.0
 */
public abstract class LotteryService {
    private EventManager eventManager;

    public LotteryService() {
        eventManager=new EventManager(EventManager.EventType.MQ,EventManager.EventType.Message);
        eventManager.subscribe(EventManager.EventType.MQ,new MQEventListener());
        eventManager.subscribe(EventManager.EventType.Message,new MessageEventListener());
    }

    public LotteryResult draw(String uId){
        LotteryResult lotteryResult = doDraw(uId);
// 需要什么通知就给调⽤什么⽅法
        eventManager.notify(EventManager.EventType.MQ, lotteryResult);
        eventManager.notify(EventManager.EventType.Message, lotteryResult);
        return lotteryResult;
    }
    protected abstract LotteryResult doDraw(String uId);
}
