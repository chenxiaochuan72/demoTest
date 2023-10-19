package test;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Author cxc
 * @Date 2023/6/12 11:45 PM
 * @Version 1.0
 * @Description:
 */

public class TestDelayed implements Delayed {

    private String str;
    private long time;

    public TestDelayed(String str, long time, TimeUnit unit) {
        this.str = str;
        this.time = System.currentTimeMillis() + (time > 0 ? unit.toMillis(time) : 0);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return time - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        TestDelayed work = (TestDelayed) o;
        long diff = this.time - work.time;
        if (diff <= 0) {
            return -1;
        } else {
            return 1;
        }
    }

    public String getStr() {
        return str;
    }
}

class fdsf {
    public static void main(String[] args) {
        DelayQueue<TestDelayed> delayQueue = new DelayQueue<TestDelayed>();
        delayQueue.offer(new TestDelayed("aaa", 5, TimeUnit.SECONDS));
        delayQueue.offer(new TestDelayed("ccc", 1, TimeUnit.SECONDS));
        delayQueue.offer(new TestDelayed("bbb", 3, TimeUnit.SECONDS));

    }
}

