package 设计模式.行为型模式.责任链模式;

/**
 * @Author cxc
 * @Date 2023/3/30 8:53 PM
 * @Version 1.0
 */

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 模拟审核服务
 */
public class AuthService {
    private static Map<String, Date> authMap = new ConcurrentHashMap<String, Date>();
    public static Date queryAuthInfo(String uId, String orderId) {
        return authMap.get(uId.concat(orderId));
    }
    public static void auth(String uId, String orderId) {
        authMap.put(uId.concat(orderId), new Date());
    }
}
