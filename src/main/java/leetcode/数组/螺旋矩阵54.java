package leetcode.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cxc
 * @Date 2023/8/8 9:41 AM
 * @Version 1.0
 * @Description:
 */

public class 螺旋矩阵54 {
    public static void main(String[] args) {
        int[][] arr={{1,2,3},{4,5,6},{7,8,9}};
        spiralOrder(arr);
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new ArrayList<Integer>();
        int l=0,r=matrix[0].length-1,t=0,b=matrix.length-1;
        List<Integer> list=new ArrayList<>();
        while(true){
            for(int i=l;i<=r;i++){
                list.add(matrix[t][i]);
            }
            t++;
            if(t>b){
                break;
            }

            for(int i=t;i<=b;i++){
                list.add(matrix[i][r]);
            }
            r--;
            if(r<l){
                break;
            }
            for(int i=r;i>=l;i--){
                list.add(matrix[b][i]);
            }
            b--;
            if(b<t){
                break;
            }
            for(int i=b;i>=t;i--){
                list.add(matrix[l][i]);
            }
            l++;
            if(l>r){
                break;
            }
        }
        return list;
    }
}
