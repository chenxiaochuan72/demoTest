package leetcode.动态规划;

public class 斐波那契数列 {
    public static void main(String[] args) {

    }

    public static int max(int n){
        if (n<=1){
            return n;
        }
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for (int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static int max1(int n){
        if (n<=1){
            return n;
        }
        int a=0;
        int b=1;
        int sum=0;
        for (int i=2;i<=n;i++){
            sum=a+b;
            a=b;
            b=sum;
        }
        return sum;
    }
}
