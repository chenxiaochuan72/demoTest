package 排序算法;

import java.util.Arrays;

/**
 * 归并排序的最好，最坏，平均时间复杂度均为O(nlogn)。
 */
public class 归并排序 {
    public static void main(String[] args) {
        int[] arr={5, 2, 8, 3, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        if(arr.length<=1){
            return ;
        }
        int mid=arr.length/2;
        int[] left= Arrays.copyOfRange(arr,0,mid);
        int[] right=Arrays.copyOfRange(arr,mid,arr.length);

        sort(left);
        sort(right);
        merge(left,right,arr);

    }
    public static void merge(int[] left,int[] right,int[] arr){
        int i=0,j=0,k=0;
        while(i<left.length&&j<right.length){
            if (left[i]<right[j]){
                arr[k++]=left[i++];
            }else {
                arr[k++]=right[j++];
            }
        }
        while(i<left.length) {
            arr[k++]=left[i++];
        }
        while (j<right.length){
            arr[k++]=right[j++];
        }
    }
}
