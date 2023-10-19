package 设计模式.结构型模式.桥接模式;

import 设计模式.结构型模式.桥接模式.channel.Pay;
import 设计模式.结构型模式.桥接模式.channel.WxPay;
import 设计模式.结构型模式.桥接模式.mode.PayCypher;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        Pay wxPay=new WxPay(new PayCypher());
        wxPay.transfer("weixin_1092033111","100000109839",new BigDecimal(100));
    }
}
