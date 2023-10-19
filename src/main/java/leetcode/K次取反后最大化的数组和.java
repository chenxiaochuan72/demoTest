package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @Author: cxc
 * @CreateTime: 2023-04-19  00:52
 * @Description: TODO
 * @Version: 1.0
 */
public class K次取反后最大化的数组和 {
    public static void main(String[] args) {
        int[] nums=new int[]{3,-1,0,2};
        int[] array = IntStream.of(nums).boxed().sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1)).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(array));
        Map<Integer,Integer> map=new HashMap<>();
    }
    static class Solution {
        public int largestSumAfterKNegations(int[] nums, int k) {
            nums= IntStream.of(nums)
                    .boxed()
                    .sorted((o1,o2)->Math.abs(o2)-Math.abs(o1))
                    .mapToInt(Integer::intValue).toArray();
            for(int i=0;i<nums.length;i++){
                if(k>0&&nums[i]<0){
                    nums[i]*=-1;
                    k--;
                }
            }
            if(k%2==1){
                nums[nums.length-1]=-nums[nums.length-1];
            }
            return Arrays.stream(nums).sum();

        }
    }
}
