package 设计模式.行为型模式.访问者模式.service;

/**
 * @Author cxc
 * @Date 2023/3/30 11:39 PM
 * @Version 1.0
 */
public class MinibusTargetService {
    /**
     * 模拟摇号，但不是摇号算法
     *
     * @param uId ⽤户编号
     * @return 结果
     */
    public String lottery(String uId) {
        return Math.abs(uId.hashCode()) % 2 == 0 ?
                "恭喜你，编 码".concat(uId).concat("在本次摇号中签") :
                "很遗憾，编 码".concat(uId).concat("在本次摇号未中签或摇号资格已过期");
    }
}
