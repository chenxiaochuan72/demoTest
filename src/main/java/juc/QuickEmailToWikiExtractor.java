package juc;

import java.math.BigDecimal;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: cxc
 * @CreateTime: 2023-04-15  23:37
 * @Description: TODO
 * @Version: 1.0
 */
public class QuickEmailToWikiExtractor {
    private ThreadPoolExecutor thradsPool;

    //    private Article
    public static void main(String[] args) {
        BigDecimal s1=new BigDecimal("2500.00");
        BigDecimal s2=new BigDecimal("5400.0");
        System.out.println(s1.compareTo(s2));
    }

}
