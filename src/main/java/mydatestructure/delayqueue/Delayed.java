package mydatestructure.delayqueue;

import java.util.concurrent.TimeUnit;

/**
 * @Author cxc
 * @Date 2023/8/30 3:35 PM
 * @Version 1.0
 * @Description:
 */

public interface Delayed extends Comparable<Delayed>{
    long getDelay(TimeUnit unit);
}
