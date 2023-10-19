package leetcode.动态规划.背包01;

public class 背包基础01 {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        System.out.println(testWeightBagProblem(weight, value, bagSize));
        System.out.println(testWeightBagProblem1(weight,value,bagSize));
    }

    /**
     * 动态规划获得结果
     *
     * @param weight  物品的重量
     * @param value   物品的价值
     * @param bagSize 背包的容量
     */
    public static int testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        /**
         * dp[i][j]  从0-i个任意个物品种取 放到容量为j的包里的最大价值
         *
         */
        // 获取物品数量
        int length=weight.length;
        int[][] dp=new int[length][bagSize+1];

        for(int i=weight[0];i<=bagSize;i++){
            dp[0][i]=value[0];
        }
        // 先循环物品
        for (int i=1;i<length;i++){
            for (int j=1;j<=bagSize;j++){
                if (j<weight[i]){
                    /**
                     * 当前背包的容量都没有当前物品i大的时候，是不放物品i的
                     * 那么前i-1个物品能放下的最大价值就是当前情况的最大价值
                     */
                    dp[i][j]=dp[i-1][j];
                }else {
                    /**
                     * 当前背包的容量可以放下物品i
                     * 那么此时分两种情况：
                     *    1、不放物品i
                     *    2、放物品i
                     * 比较这两种情况下，哪种背包中物品的最大价值最大
                     */
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-weight[i]] + value[i]);

                }
            }
        }
        return dp[length-1][bagSize];
    }

    public static int testWeightBagProblem1(int[] weight, int[] value, int bagWeight){
        /**
         * dp[j] 表示 dp[j]表示背包容量为j的时候，能获得的最大价值
         */

        int wLength=weight.length;

        int[] dp=new int[bagWeight+1];

        for (int i=0;i<wLength;i++){
            for (int j=bagWeight;j>=weight[i];j--){
                dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
        return dp[bagWeight];
    }
}
