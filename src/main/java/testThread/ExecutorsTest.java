package testThread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author cxc
 * @Date 2023/6/24 8:48 PM
 * @Version 1.0
 * @Description:
 */
@Slf4j
public class ExecutorsTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i=1;i<5;i++){
            int groupId=i;
            service.execute(()->{
                for (int j=1;j<5;j++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    log.info("第 {} 组任务，第 {} 次执行完成", groupId, j);
                }
            });
        }
        service.shutdown();
    }
}
