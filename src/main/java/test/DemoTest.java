package test;

import java.math.BigDecimal;

/**
 * @Author: cxc
 * @CreateTime: 2023-04-09  15:07
 * @Description: TODO
 * @Version: 1.0
 */
public class DemoTest {
    public static void main(String[] args) {
        BigDecimal bigDecimal=new BigDecimal(0.95);
        BigDecimal rate=new BigDecimal(0.15);
        System.out.println(rate.divide(bigDecimal, 2, BigDecimal.ROUND_UP));
    }
}
