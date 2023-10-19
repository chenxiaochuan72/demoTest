package 设计模式.行为型模式.策略模式.design.test;

import 设计模式.行为型模式.策略模式.design.Context;
import 设计模式.行为型模式.策略模式.design.event.ZJCouponDiscount;

import java.math.BigDecimal;

public class Test_ZJ {
    public static void main(String[] args) {
        Context<Double> context=new Context<>(new ZJCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(10D, new BigDecimal(100));
        System.out.println("测试结果：直减优惠后⾦额: "+discountAmount);
    }
}
