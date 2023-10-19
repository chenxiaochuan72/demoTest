package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: cxc
 * @CreateTime: 2023-04-06  00:37
 * @Description: TODO
 * @Version: 1.0
 */
public class 子集问题 {
    List<List<Integer>> result=new ArrayList<>();
    Deque<Integer> path=new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTracking(nums,(0));
        return result;
    }
    private void backTracking(int[] nums,int startIndex){
        result.add(new ArrayList<>(path));
        System.out.println(result.toString());
        if(startIndex>=nums.length){
            return;
        }
        for(int i=startIndex;i<nums.length;i++){
            path.addLast(nums[i]);
            backTracking(nums,i+1);
            path.removeLast();

        }
    }

    public static void main(String[] args) {
        子集问题 s=new 子集问题();
        s.subsets(new int[]{1,2,3});
    }
}
