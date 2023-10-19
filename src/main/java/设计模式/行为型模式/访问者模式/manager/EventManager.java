package 设计模式.行为型模式.访问者模式.manager;


import 设计模式.行为型模式.访问者模式.LotteryResult;
import 设计模式.行为型模式.访问者模式.event.EventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author cxc
 * @Date 2023/3/30 11:46 PM
 * @Version 1.0
 */
public class EventManager {
    Map<Enum<EventType>, List<EventListener>> listeners=new HashMap<Enum<EventType>, List<EventListener>>();
    public EventManager(Enum<EventType>... operations){
        for (Enum<EventType> operation:operations){
            this.listeners.put(operation,new ArrayList<>());
        }
    }

    public enum EventType {
        MQ, Message
    }

    /**
     *  订阅
     * @param eventType 时间类型
     * @param listener 监听
     */
    public void subscribe(Enum<EventType> eventType,EventListener listener){
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }
    /**
     * 取消订阅
     * @param eventType 事件类型
     * @param listener 监听
     */
    public void unsubscribe(Enum<EventType> eventType, EventListener
            listener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }
    /**
     * 通知
     * @param eventType 事件类型
     * @param result 结果
     */
    public void notify(Enum<EventType> eventType, LotteryResult result) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.doEvent(result);
        }
    }
}
