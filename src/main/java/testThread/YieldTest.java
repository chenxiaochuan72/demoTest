package testThread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author cxc
 * @Date 2023/6/24 8:26 PM
 * @Version 1.0
 * @Description:
 */

public class YieldTest {
    private static volatile Map<String, AtomicInteger> count=new ConcurrentHashMap<>();
    static class Y implements Runnable{
        private String name;
        private boolean isYield;

        public Y(String name, boolean isYield) {
            this.name = name;
            this.isYield = isYield;
        }

        @Override
        public void run() {
            long l = System.currentTimeMillis();
            for (int i=0;i<1000;i++){
                if (isYield){
                    Thread.yield();
                }
                AtomicInteger atomicInteger = count.get(name);
                if (null==atomicInteger){
                    count.put(name,new AtomicInteger(1));
                    continue;
                }
                atomicInteger.addAndGet(1);
                count.put(name,atomicInteger);
            }
            System.out.println("线程编号：" + name + " 执行完成耗时：" + (System.currentTimeMillis() - l) + " (毫秒)" + (isYield ? "让出CPU----------------------" : "不让CPU"));

        }
    }

    public static void main(String[] args) {
        for (int i=0;i<50;i++){
            if (i<10){
                new Thread(new Y(String.valueOf(i),true)).start();
            }
            new Thread(new Y(String.valueOf(i), false)).start();
        }
    }
}
