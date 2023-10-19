package 设计模式.结构型模式.享元模式.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 这⾥处理模拟 redis 的操作⼯具类外，还提供了⼀个定时任务⽤于模拟库存的使⽤，这样⽅⾯我
 * 们在测试的时候可以观察到库存的变化。
 */
public class RedisUtils {

    private ScheduledExecutorService service= Executors.newScheduledThreadPool(1);

    private AtomicInteger stock=new AtomicInteger(0);

    public RedisUtils() {
        service.scheduleAtFixedRate(()->{
            stock.addAndGet(1);
        },0,100000, TimeUnit.MICROSECONDS);
    }

    public int getStockUsed(){
        return stock.get();
    }
}
