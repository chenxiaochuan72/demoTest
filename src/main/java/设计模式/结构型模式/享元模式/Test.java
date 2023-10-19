package 设计模式.结构型模式.享元模式;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author cxc
 * @Date 2023/3/29 8:27 PM
 * @Version 1.0
 */
@Slf4j
public class Test {


    public static void main(String[] args) throws InterruptedException {
        ActivityController activityController = new ActivityController();

        for (int idx = 0; idx < 10; idx++) {
            Long req = 10001L;
            Activity activity = activityController.queryActivityInfo(req);
            log.info("测试结果：{} {}", req, activity.toString());
            Thread.sleep(1200);
        }
    }
}
