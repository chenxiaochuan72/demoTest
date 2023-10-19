package leetcode.数组;

/**
 * @Author cxc
 * @Date 2023/8/1 12:46 AM
 * @Version 1.0
 * @Description:
 */

public class 有序数组的平方977 {
    public static void main(String[] args) {
        new Solution().sortedSquares(new int[]{-7,-3,2,3,11});
    }
     static class Solution {
        public int[] sortedSquares(int[] nums) {
            int[] arr=new int[nums.length];
            int k=nums.length-1;
            int i=0,j=nums.length-1;
            while(i<j){
                if(nums[i]*nums[i]>=nums[j]*nums[j]){
                    arr[k--]=nums[i]*nums[i];
                    i++;
                }else{
                    arr[k--]=nums[j]*nums[j];
                    j--;
                }
            }
            return arr;

        }
    }
}
