package leetcode.数组;

/**
 * @Author cxc
 * @Date 2023/7/30 11:28 PM
 * @Version 1.0
 * @Description:
 */

public class 移除元素27 {
    public static int removeElement(int[] nums, int val) {
        int slow=0;
        for(int fast=0;fast<nums.length;fast++){
            if(nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        removeElement(new int[]{0,1,2,2,3,0,4,2},2);
    }
}
