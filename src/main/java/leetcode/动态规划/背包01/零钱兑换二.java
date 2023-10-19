package leetcode.动态规划.背包01;

import java.util.Arrays;

public class 零钱兑换二 {
    public static void main(String[] args) {
        int[] coins={1,2,5};
        System.out.println(change(5,coins));
    }
    public static int change(int amount, int[] coins) {
        /*
         * dp[i] 凑合i金额最多dp[i]中方法
         */

        int[] dp=new int[amount+1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j]+=dp[j-coins[i]];
            }
        }


        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }
}
