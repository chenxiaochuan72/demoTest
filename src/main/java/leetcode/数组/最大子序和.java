package leetcode.数组;

/**
 * @Author cxc
 * @Date 2023/7/27 12:35 AM
 * @Version 1.0
 * @Description:
 */

public class 最大子序和 {
    /**
     * dp[i]数组含义 第i个元素时候的最大子序和
     * dp[i]=Math.max(dp[i-1],dp[i-1]+dp[i])
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int result=nums[0];
        int pre=result;
        for(int i=1;i<nums.length;i++){
            pre=Math.max((pre+nums[i]),pre);
            if(pre>result){
                result=pre;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(最大子序和.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
