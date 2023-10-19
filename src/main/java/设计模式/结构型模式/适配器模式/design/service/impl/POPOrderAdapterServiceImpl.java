package 设计模式.结构型模式.适配器模式.design.service.impl;

import 设计模式.结构型模式.适配器模式.design.service.OrderAdapterService;
import 设计模式.结构型模式.适配器模式.service.POPOrderService;

public class POPOrderAdapterServiceImpl implements OrderAdapterService {
    private POPOrderService popOrderService;
    @Override
    public boolean isFirst(String uId) {
        return popOrderService.isFirstOrder(uId);
    }
}
