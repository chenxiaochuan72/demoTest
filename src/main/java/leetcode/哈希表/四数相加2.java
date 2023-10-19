package leetcode.哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cxc
 * @Date 2023/8/21 1:15 AM
 * @Version 1.0
 * @Description:
 */

public class 四数相加2 {
    public static void main(String[] args) {
        int[] nums1 = {1,2}, nums2 = {-2,-1}, nums3 = {-1,2}, nums4 = {0,2};
        Solution12 solution12 = new Solution12();
        solution12.fourSumCount(nums1,nums2,nums3,nums4);
    }
}
class Solution12 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map=new HashMap<>();
        int temp=0;
        int res=0;
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                temp=nums1[i]+nums2[j];
                if(map.containsKey(temp)){
                    map.put(temp,map.get(temp)+1);
                }else{
                    map.put(temp,1);
                }
            }
        }
        for(int i=0;i<nums3.length;i++){
            for(int j=0;j<nums4.length;j++){
                temp=nums3[i]+nums4[j];
                if(map.containsKey(0-temp)){
                    res+=map.get(0-temp);
                }
            }
        }
        return res;
    }
}
