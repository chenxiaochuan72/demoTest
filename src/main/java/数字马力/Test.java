package 数字马力;

/**
 * @Author cxc
 * @Date 2023/8/1 7:21 PM
 * @Version 1.0
 * @Description:
 */

public class Test {
    public static void main(String[] args) {
        TaxCalculator taxCalculator = new TaxCalculator();
        double amout=70000;
        double tax=taxCalculator.calculateTax(amout);
        System.out.println("税前金额:"+amout+"税额"+tax);
    }
}
