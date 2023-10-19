package 排序算法;

import java.util.Arrays;

/**
 * @Author cxc
 * @Date 2023/6/3 11:22 PM
 * @Version 1.0
 * @Description: 哨兵划分操作： 以数组某个元素（一般选取首元素）为 基准数 ，
 *  将所有小于基准数的元素移动至其左边，大于基准数的元素移动至其右边。
 */

public class 快速排序 {
    public static void main(String[] args) {
        int[] arr={1,5,2,6,7,2,1645,7546};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    private static void quickSort(int[] arr,int l,int r){
        if(l>=r){
            return;
        }
        int i=l,j=r;
        while (i<j){
            while (i<j&&arr[j]>=arr[l]){
                j--;
            }
            while(i<j&&arr[i]<=arr[l]){
                i++;
            }
            swap(arr,i,j);
        }
        // 和基准树交换位置
        swap(arr,i,l);
        quickSort(arr,l,i-1);
        quickSort(arr,i+1,r);

    }

    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}
