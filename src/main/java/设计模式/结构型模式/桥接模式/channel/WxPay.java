package 设计模式.结构型模式.桥接模式.channel;

import lombok.extern.slf4j.Slf4j;
import 设计模式.结构型模式.桥接模式.mode.IpayMode;

import java.math.BigDecimal;

/**
 * 支付类型具体实现
 */
@Slf4j
public class WxPay extends Pay{
    public WxPay(IpayMode payMode) {
        super(payMode);
    }

    @Override
    public String transfer(String uId, String tradeId, BigDecimal amount) {
        log.info("模拟微信渠道⽀付划账开始。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
        boolean security = payMode.security(uId);
        log.info("模拟微信渠道⽀付⻛控校验。uId：{} tradeId：{} security： {}", uId, tradeId, security);
        if (!security) {
            log.info("模拟微信渠道⽀付划账拦截。uId：{} tradeId：{} amount： {}", uId, tradeId, amount);
            return "0001";
        }
        log.info("模拟微信渠道⽀付划账成功。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
        return "0000";
    }
}
