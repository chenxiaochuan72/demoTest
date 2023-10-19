package leetcode.数组;

/**
 * @Author cxc
 * @Date 2023/7/27 12:40 AM
 * @Version 1.0
 * @Description:
 */

public class 搜索插入位置 {
    public static int searchInsert(int[] nums, int target) {
        // 找出数组中第一个大于等于target的值
        if(nums==null||nums.length<=0){
            return -1;
        }
        int left=0;
        int right=nums.length-1;
        int result=nums.length;
        while(left<=right){
            int mid=(left+right)/2;
            if(target<=nums[mid]){
                result=mid;
                right=mid-1;
            }else{

                left=mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        搜索插入位置.searchInsert(new int[]{1,3,5,6,7},5);
    }
}
