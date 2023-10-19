package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author cxc
 * @Date 2023/3/29 10:11 PM
 * @Version 1.0
 */
public class 组合总和 {
    static List<List<Integer>> result=new ArrayList<>();
    static LinkedList<Integer> path=new LinkedList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        back(candidates,target,0,0);
        return result;
    }

    static void  back(int[] candidates,int target,int startIndex,int sum){
        if(sum>target){
            return;
        }
        if(sum==target){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<candidates.length;i++){
            path.add(candidates[i]);
            sum+=candidates[i];
            back(candidates,target,i,sum);
            sum-=candidates[i];
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        combinationSum(new int[]{8,7,4,3},11);
    }
}
