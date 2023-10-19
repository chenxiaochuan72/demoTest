package leetcode.数组;

import java.util.Arrays;

/**
 * @Author cxc
 * @Date 2023/8/18 2:13 PM
 * @Version 1.0
 * @Description:
 */

public class 最小K个数 {
}
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr,k,0,arr.length-1);
        return Arrays.copyOf(arr,k);

    }

    private void quickSort(int[] arr,int k,int l,int r){
        if(l>=r){
            return;
        }
        int i=l,j=r;
        while(i<j){
            while(i<j&&arr[j]>=arr[l]){
                j--;
            }
            while(i<j&&arr[i]<=arr[l]){
                i++;
            }
            swap(arr,i,j);
        }
        swap(arr,i,l);
        if(i<k){
            quickSort(arr,k,i+1,r);
        }else{
            quickSort(arr,k,l,i-1);
        }
    }
    private void swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }

}