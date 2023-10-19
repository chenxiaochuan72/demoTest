package leetcode;

import java.util.Arrays;

/**
 * @Author: cxc
 * @CreateTime: 2023-04-20  01:03
 * @Description: TODO
 * @Version: 1.0
 */
public class 分发糖果 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.candy(new int[]{1,0,2});
    }
    static class Solution {
        public int candy(int[] ratings) {
            int[] result=new int[ratings.length];
            Arrays.fill(result,1);
            // 右边分数比左边大
            for(int i=1;i<ratings.length;i++){
                if(ratings[i]>ratings[i-1]){
                    result[i]=result[i-1]+1;
                }
            }
            // 左边分数比右边大
            for(int i=ratings.length-2;i>=0;i--){
                if(ratings[i]>ratings[i+1]){
                    result[i]=Math.max(result[i],result[i+1]+1);
                }
            }
            int sum=0;
            for(int i=0;i<result.length;i++){
                sum+=result[i];
            }
            return sum;
        }
    }
}
