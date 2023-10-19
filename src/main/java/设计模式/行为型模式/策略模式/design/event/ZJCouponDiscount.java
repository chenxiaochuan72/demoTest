package 设计模式.行为型模式.策略模式.design.event;

import 设计模式.行为型模式.策略模式.design.ICouponDiscount;

import java.math.BigDecimal;

public class ZJCouponDiscount implements ICouponDiscount<Double> {
    /**
     * 直减计算
     * 1. 使⽤商品价格减去优惠价格
     * 2. 最低⽀付⾦额1元
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(couponInfo));
        if(discountAmount.compareTo(BigDecimal.ZERO)<1){
            return BigDecimal.ONE;
        }
        return discountAmount;
    }
}
