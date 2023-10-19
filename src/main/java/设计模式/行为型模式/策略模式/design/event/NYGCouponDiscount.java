package 设计模式.行为型模式.策略模式.design.event;

import 设计模式.行为型模式.策略模式.design.ICouponDiscount;

import java.math.BigDecimal;

public class NYGCouponDiscount implements ICouponDiscount<Double> {
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        /**
         * n元购购买
         * 1. ⽆论原价多少钱都固定⾦额购买
         */
        return new BigDecimal(couponInfo);
    }
}
