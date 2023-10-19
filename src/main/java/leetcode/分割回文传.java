package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: cxc
 * @CreateTime: 2023-04-04  00:29
 * @Description: TODO
 * @Version: 1.0
 */
public class 分割回文传 {
    List<List<String>> result=new ArrayList<>();
    Deque<String> path=new LinkedList<>();
    public List<List<String>> partition(String s) {
        backTracking(s,0);
        return result;
    }

    private void backTracking(String s,int startIndex){
        if(startIndex>=s.length()){
            for (String str:path){
                if (isPalindrome(str,0,str.length()-1)){
                    continue;
                }else {
                    return;
                }
            }
            result.add(new ArrayList<>(path));
        }

        for(int i=startIndex;i<s.length();i++){
//            if(isPalindrome(s,startIndex,i)){
                path.addLast(s.substring(startIndex,i+1));

//            }else{
//                continue;
//            }
            backTracking(s,i+1);
            path.removeLast();
        }
    }


    private boolean isPalindrome(String s,int left,int right){
        for(int i=left, j=right;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        分割回文传 s=new 分割回文传();
        List<List<String>> aab = s.partition("aab");
        System.out.println(aab);
    }
}
