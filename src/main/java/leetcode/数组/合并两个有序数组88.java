package leetcode.数组;

/**
 * @Author cxc
 * @Date 2023/8/1 6:24 PM
 * @Version 1.0
 * @Description:
 */

public class 合并两个有序数组88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while(len1 >= 0 && len2 >= 0) {
            // 注意--符号在后面，表示先进行计算再减1，这种缩写缩短了代码
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
        if(len2>=0){
            for(int j=len2;j>=0;j--){
                nums1[len--]=nums2[j];
            }
        }
    }

    public static void main(String[] args) {
        merge(new int[0],0,new int[]{1},1);
    }
}
