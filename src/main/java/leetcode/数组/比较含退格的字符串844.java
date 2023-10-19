package leetcode.数组;

/**
 * @Author cxc
 * @Date 2023/7/31 11:57 PM
 * @Version 1.0
 * @Description:
 */

public class 比较含退格的字符串844 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.backspaceCompare("ab#c","ad#c");
    }
     static class Solution {
        //
        public boolean backspaceCompare(String s, String t) {
            int sIndex=s.length()-1;
            int tIndex=t.length()-1;
            int sSum=0;
            int tSum=0;
            while(sIndex>=0||tIndex>=0){
                while(sIndex>=0){
                    if(s.charAt(sIndex)=='#'){
                        sSum++;
                        sIndex--;
                    }else if(sSum>0){
                        sSum--;
                        sIndex--;
                    }else{
                        break;
                    }
                }
                while(tIndex>=0){
                    if(t.charAt(tIndex)=='#'){
                        tSum++;
                        tIndex--;
                    }else if(tSum>0){
                        tSum--;
                        tIndex--;
                    }else{
                        break;
                    }
                }
                if(tIndex>=0&&sIndex>=0){
                    if(s.charAt(sIndex)!=t.charAt(tIndex)){
                        return false;
                    }
                }else{
                    if(sIndex>=0||tIndex>=0){
                        return false;
                    }
                }
                tIndex--;
                sIndex--;
            }
            return true;
        }
    }
}
