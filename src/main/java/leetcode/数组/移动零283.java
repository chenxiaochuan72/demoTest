package leetcode.数组;

/**
 * @Author cxc
 * @Date 2023/7/31 12:05 AM
 * @Version 1.0
 * @Description:
 */

public class 移动零283 {
    public static void moveZeroes(int[] nums) {
        if(nums==null) {
            return;
        }
        //两个指针i和j
        int j = 0;
        for(int i=0;i<nums.length;i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if(nums[i]!=0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }
    public static void moveZeroes1(int[] nums) {
        int slow=0;
        for(int fast=0;fast<nums.length;fast++){
            if(nums[fast]!=0){
                int temp=nums[slow];
                nums[slow]=nums[fast];
                nums[fast]=nums[slow++];
            }
        }
    }

    public static void main(String[] args) {
        moveZeroes1(new int[]{0,1,0,3,12});
    }
}
