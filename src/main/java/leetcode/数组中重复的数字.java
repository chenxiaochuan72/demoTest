package leetcode;

/**
 * @Author cxc
 * @Date 2023/6/16 12:13 AM
 * @Version 1.0
 * @Description:
 */

public class 数组中重复的数字 {
    public static void main(String[] args) {
        int[] arr=new int[]{3,4,2,1,1,0};
        Solution12 solution12=new Solution12();

        solution12.findRepeatNumber(arr);
    }
}
class Solution12 {
    public int findRepeatNumber(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(i==nums[i]){
                continue;
            }
            if(nums[nums[i]]==nums[i]){
                return nums[i];
            }
            int temp=nums[i];
            nums[i]=nums[temp];
            nums[temp]=temp;
        }
        return -1;
    }
}