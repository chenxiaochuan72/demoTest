package leetcode;

/**
 * @Author cxc
 * @Date 2023/7/4 1:11 AM
 * @Version 1.0
 * @Description:
 */

public class 数值的整数次方 {
    public static void main(String[] args) {
        myPow(2,10);
        System.out.println((3&1)==1);
    }
    public static double myPow(double x, int n) {
        if(x==0){
            return 0;
        }
        int b=n;
        double res=1.0d;
        if(b<0){
            b=-b;
            x=1/x;
        }
        while(b!=0){
            if((b&1)==1){
                res=res*x;
            }
            x=x*x;
            b=b/2;
        }
        return res;
    }
}
