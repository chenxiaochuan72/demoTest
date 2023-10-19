package leetcode.数组;

/**
 * @Author cxc
 * @Date 2023/7/27 12:55 AM
 * @Version 1.0
 * @Description:
 */

public class 在排序数组中查找元素的第一个和最后一个位置 {
    public static int[] searchRange(int[] nums, int target) {
        //先找>=target的第一个
        //再找>target的第一个
        //我真是这辈子都不想看见这题
        if(nums==null||nums.length<=0){
            return new int[]{-1,-1};
        }
        int l=search(nums,target);
        int r=search(nums,target+1);
        if(l==nums.length||nums[l]!=target){
            return new int[]{-1,-1};
        }
        return new int[]{l,r-1};
    }
    public static int search(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        int index=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(target<=nums[mid]){
                index=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(在排序数组中查找元素的第一个和最后一个位置.searchRange(new int[]{2, 2}, 2));
    }
}
