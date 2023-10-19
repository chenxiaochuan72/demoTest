package leetcode.动态规划.背包01;

public class 完全背包 {
    /**
     * 有N件物品和一个最多能背重量为W的背包。第i件物品的重量是weight[i]，
     * 得到的价值是value[i] 。每件物品都有无限个（也就是可以放入背包多次），
     * 求解将哪些物品装入背包里物品价值总和最大。
     * @param args
     */
    public static void main(String[] args) {
        testCompletePack();
        System.out.println();
        testCompletePackAnotherWay();
    }
    //先遍历物品，再遍历背包
    private static void testCompletePack(){
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.length; i++){ // 遍历物品
            for (int j = weight[i]; j <= bagWeight; j++){ // 遍历背包容量
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        for (int maxValue : dp){
            System.out.print(maxValue + "   ");
        }
    }

    //先遍历背包，再遍历物品
    private static void testCompletePackAnotherWay(){
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        int[] dp = new int[bagWeight + 1];
        for (int i = 1; i <= bagWeight; i++){ // 遍历背包容量
            for (int j = 0; j < weight.length; j++){ // 遍历物品
                if (i - weight[j] >= 0){
                    dp[i] = Math.max(dp[i], dp[i - weight[j]] + value[j]);
                }
            }
        }
        for (int maxValue : dp){
            System.out.print(maxValue + "   ");
        }
    }

}
