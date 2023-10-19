package 设计模式.结构型模式.享元模式;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 */
public class ActivityFactory {
    static Map<Long,Activity> activityMap=new HashMap<>();

    public static Activity getActivicy(Long id){
        Activity activity=activityMap.get(id);
        if(null==activity){
            // 模拟从实际业务中获取活动信息
            activity = new Activity();
            activity.setId(10001L);
            activity.setName("图书嗨乐");
            activity.setDesc("图书优惠券分享激励分享活动第⼆期");
            activity.setStartTime(new Date());
            activity.setStopTime(new Date());
            activityMap.put(id, activity);
        }
        return activity;
    }
}
