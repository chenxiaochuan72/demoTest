package leetcode;

import java.math.BigDecimal;

/**
 * @Author: cxc
 * @CreateTime: 2023-04-18  00:25
 * @Description: TODO
 * @Version: 1.0
 */
public class 跳跃游戏 {
    public static void main(String[] args) {
//        Solution solution=new Solution();
//        solution.canJump(new int[]{2,3,1,1,4});
//        Solution2 solution2=new Solution2();
//        System.out.println(solution2.jump(new int[]{2, 3, 1, 1, 4, 1, 2, 5, 1, 2}));
        BigDecimal s1=new BigDecimal("1500");
        BigDecimal s2=new BigDecimal("2000");
        System.out.println(s1.compareTo(s2));
    }
   static class Solution {
        public boolean canJump(int[] nums) {
            if(nums.length==1){
                return true;
            }
            int cover=0;
            for(int i=0;i<=cover;i++){
                cover=Math.max(i+nums[i],cover);
                if(cover==nums.length-1){
                    return true;
                }

            }
            return false;
        }
    }
    static class Solution2 {
        public int jump(int[] nums) {
            if(nums.length==1){
                return 0;
            }
            // 当前覆盖距离
            int cur=0;
            // 最大的覆盖距离
            int next=0;
            int result=0;
            for(int i=0;i<nums.length;i++){
                next=Math.max(i+nums[i],next);
                // 如果当前走的和覆盖距离相同
                // 判断当前覆盖具体是否等于到底最后一个位置，如果不到达，继续走一步。
                if(i==cur){
                    if(cur!=nums.length-1){
                        result++;
                        cur=next;
                        if(cur>=nums.length-1){
                            break;
                        }
                    }
                }
            }
            return result;

        }
    }
}
