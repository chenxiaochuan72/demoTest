package leetcode;

public class 剪绳子 {
    static class Solution {
        public int cuttingRope(int n) {
            if(n<=1){
                return 0;
            }
            if(n==2){
                return 1;
            }
            int res=n/3;
            int mod=n%3;
            if(mod==0){
                return pow(3,res);
            }else if(mod==1){
                return pow(3,res-1)*4;
            }else{
                return pow(3,res)*2;
            }
        }
        int pow(int a,int b){
            int sum=1;
            for(int i=1;i<=b;i++){
                sum=sum*a;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.cuttingRope(10));
    }
}

