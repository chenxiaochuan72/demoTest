package 设计模式.结构型模式.桥接模式.mode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PayFaceMode implements IpayMode{
    @Override
    public boolean security(String uId) {
        log.info("人脸识别，风控校验识别");
        return true;
    }
}
