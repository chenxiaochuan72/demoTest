package leetcode.动态规划.买卖股票;

public class 买卖股票的最佳时机121 {
    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        maxProfit(prices);

    }
    public static int maxProfit(int[] prices) {
        /***
         动态数组
         */
        if(prices==null||prices.length==0){
            return 0;
        }
        // dp[i][0]代表第i天持有股票的最大收益
        // dp[i][1]代表第i天不持有股票的最大收益
        int length=prices.length;
        int[][] dp=new int[length][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0;

        for(int i=1;i<length;i++){
            dp[i][0]=Math.max(dp[i-1][0],-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        for (int i=0;i<length;i++){
            for (int j=0;j<2;j++){
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }

        return dp[length-1][1];
    }
}
