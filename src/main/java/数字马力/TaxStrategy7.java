package 数字马力;

/**
 * @Author cxc
 * @Date 2023/8/1 7:11 PM
 * @Version 1.0
 * @Description:
 */

public class TaxStrategy7 implements TaxStrategy{
    @Override
    public double calculateTax(double amount) {
        return amount*0.45;
    }
}
