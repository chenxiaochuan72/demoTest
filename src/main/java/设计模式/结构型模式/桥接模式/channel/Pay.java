package 设计模式.结构型模式.桥接模式.channel;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import 设计模式.结构型模式.桥接模式.mode.IpayMode;

import java.math.BigDecimal;

/**
 * ⽀付类型桥接抽象类
 */
public abstract class Pay {
    protected Logger logger = LoggerFactory.getLogger(Pay.class);
    protected IpayMode payMode;

    public Pay(IpayMode payMode) {
        this.payMode = payMode;
    }
    public abstract String transfer(String uId, String tradeId, BigDecimal amount);
}
