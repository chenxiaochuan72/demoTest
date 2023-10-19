package 设计模式.结构型模式.桥接模式.mode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PayCypher implements IpayMode{
    @Override
    public boolean security(String uId) {
        log.info("密码支付，风控校验环境安全");
        return true;
    }
}
