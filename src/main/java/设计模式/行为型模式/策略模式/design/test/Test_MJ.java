package 设计模式.行为型模式.策略模式.design.test;

import 设计模式.行为型模式.策略模式.design.Context;
import 设计模式.行为型模式.策略模式.design.event.MJCouponDiscount;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Test_MJ {
    public static void main(String[] args) {
        Context<Map<String,String>> context=new Context<Map<String, String>>(new MJCouponDiscount());
        Map<String,String> mapReq=new HashMap<>();
        mapReq.put("x","100");
        mapReq.put("n","10");
        BigDecimal bigDecimal = context.discountAmount(mapReq, new BigDecimal(100));
        System.out.println("测试结果：满减优惠后⾦额: "+bigDecimal);
    }
}
