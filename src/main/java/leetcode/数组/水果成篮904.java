package leetcode.数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cxc
 * @Date 2023/8/2 11:46 PM
 * @Version 1.0
 * @Description:
 */

public class 水果成篮904 {
    public static void main(String[] args) {
        水果成篮904.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4});
    }
    public static int totalFruit(int[] fruits) {
        int left=0;
        int sum=0;
        Map<Integer,Integer> map=new HashMap<>();
        int result=Integer.MIN_VALUE;
        for(int right=0;right<=fruits.length-1;right++){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            while(map.size()>2){

                map.remove(fruits[left]);

                left++;
            }
            result=Math.max(result,right-left+1);
        }
        return result;


    }
}
