package leetcode;

/**
 * @Author: cxc
 * @CreateTime: 2023-04-13  17:20
 * @Description: TODO
 * @Version: 1.0
 */
public class 接雨水 {
    public static void main(String[] args) {
        int[] arr=new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        Solution123 solution13=new Solution123();
        solution13.trap(arr);
    }
}
class Solution13 {
    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }
}


class Solution123 {
    public int trap(int[] height) {
        int n=height.length;
        if(n==0){
            return 0;
        }
        int[] leftMax=new int[n];
        int[] rightMax=new int[n];

        leftMax[0]=height[0];
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(leftMax[i-1],height[i]);
        }
        rightMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(height[i],rightMax[i+1]);
        }
        int res=0;
        for(int i=0;i<n;i++){
            res=Math.min(leftMax[i],rightMax[i])-height[i];
        }

        return res;
    }
}
