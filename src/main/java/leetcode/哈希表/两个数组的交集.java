package leetcode.哈希表;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author cxc
 * @Date 2023/8/16 12:39 AM
 * @Version 1.0
 * @Description:
 */

public class 两个数组的交集 {
    public static void main(String[] args) {
        两个数组的交集.intersection(new int[]{1,2,2,1},new int[]{2,2});
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<Integer>();
        Set<Integer> result=new HashSet<Integer>();
        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        int[] arr=new int[Math.min(nums1.length,nums2.length)];
        for(int i=0;i<nums2.length;i++){
            if(set.contains(nums2[i])){
                result.add(nums2[i]);
            }
        }
        int j=0;
        Iterator<Integer> it=set.iterator();
        while(it.hasNext()){
            arr[j++]=it.next();
        }
        return arr;
    }
}
