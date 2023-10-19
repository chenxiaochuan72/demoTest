package 设计模式.结构型模式.桥接模式.mode;

/**
 * 定义支付模式接口
 */
public interface IpayMode {
    boolean security(String uId);
}
