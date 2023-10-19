package mydatestructure.delayqueue;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @Author cxc
 * @Date 2023/8/31 4:45 PM
 * @Version 1.0
 * @Description:
 */

public class Job implements Delayed, Serializable {


    private final String name;
    private final Long begin;
    private final Long delayTime;

    public Job(String name, Long delayTime) {
        this.name = name;
        this.begin = System.currentTimeMillis();
        this.delayTime = delayTime;//延时时长
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(begin + delayTime - System.currentTimeMillis(), TimeUnit.MICROSECONDS);
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Delayed o) {
        Job job = (Job) o;
        return (int) (this.getDelay(TimeUnit.MICROSECONDS) - job.getDelay(TimeUnit.MICROSECONDS));
    }
}
