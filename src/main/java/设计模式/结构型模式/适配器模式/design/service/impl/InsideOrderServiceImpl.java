package 设计模式.结构型模式.适配器模式.design.service.impl;

import 设计模式.结构型模式.适配器模式.design.service.OrderAdapterService;
import 设计模式.结构型模式.适配器模式.service.OrderService;

/**
 * 内部商品接⼝
 */
public class InsideOrderServiceImpl implements OrderAdapterService {
    private OrderService orderService=new OrderService();
    @Override
    public boolean isFirst(String uId) {

        return orderService.queryUserOrderCount(uId)<=1;
    }
}
