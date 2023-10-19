package leetcode;

/**
 * @Author cxc
 * @Date 2023/6/4 12:23 AM
 * @Version 1.0
 * @Description:
 */

public class 连续子数组的最大和 {
    public static void main(String[] args) {
        int[] arr={-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(arr);
    }
    public static int maxSubArray(int[] nums) {
        int[] dp=new int[nums.length+1];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],Math.max(0,nums[i]));
        }
        return dp[nums.length-1];
    }
}
