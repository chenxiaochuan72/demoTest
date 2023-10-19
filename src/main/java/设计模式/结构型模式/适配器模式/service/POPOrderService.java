package 设计模式.结构型模式.适配器模式.service;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

public class POPOrderService {
    private Logger logger =
            LoggerFactory.getLogger(POPOrderService.class);
    public boolean isFirstOrder(String uId) {
        logger.debug("POP商家，查询⽤户的订单是否为⾸单：{}", uId);
        return true;
    }
}
