package leetcode.数组;

/**
 * @Author cxc
 * @Date 2023/8/2 11:29 PM
 * @Version 1.0
 * @Description:
 */

public class 长度最小的子数组209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int sum=0;
        int result=Integer.MAX_VALUE;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while(target<=sum){
                result=Math.min(result,right-left+1);
                sum-=nums[left++];
            }
        }
        return result==Integer.MAX_VALUE?0:result;
    }
    public static void main(String[] args) {

        长度最小的子数组209.minSubArrayLen(7,new int[]{2,3,1,2,4,3});
    }
}
