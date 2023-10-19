package 数字马力;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cxc
 * @Date 2023/8/1 7:15 PM
 * @Version 1.0
 * @Description:
 */

public class TaxCalculator {
    private final Map<Double,TaxStrategy> taxStrategyMap=new HashMap<>();
    public TaxCalculator(){
        taxStrategyMap.put(5000.0,new TaxStrategy0());
        taxStrategyMap.put(8000.0,new TaxStrategy1());
        taxStrategyMap.put(17000.0,new TaxStrategy2());
        taxStrategyMap.put(30000.0,new TaxStrategy3());
        taxStrategyMap.put(4000.0,new TaxStrategy4());
        taxStrategyMap.put(6000.0,new TaxStrategy5());
        taxStrategyMap.put(85000.0,new TaxStrategy6());
        taxStrategyMap.put(Double.POSITIVE_INFINITY,new TaxStrategy7());

    }
    public double calculateTax(double amount) {
// TODO
        // 用作返回值
        double tax=0;
        double prevThreshold=0;
        for (double threshold:taxStrategyMap.keySet()){
            TaxStrategy taxStrategy = taxStrategyMap.get(threshold);
            if (amount<=threshold){
                tax+=taxStrategy.calculateTax(amount-prevThreshold);
                break;
            }else {
                tax+=taxStrategy.calculateTax(threshold-prevThreshold);
                prevThreshold=threshold;
            }
        }
        return tax;
    }

}
