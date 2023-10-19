package leetcode.字符串;

/**
 * @Author cxc
 * @Date 2023/8/29 3:17 PM
 * @Version 1.0
 * @Description:
 */

public class 翻转字符串里的单词151 {
    public static void main(String[] args) {

        Solution1 solution=new Solution1();
        solution.reverseWords("the sky is blue");
    }

}
class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        int j=s.length()-1,i=j;
        StringBuilder sb=new StringBuilder();
        while(i>=0){
            while(i>=0&&s.charAt(i)!=' '){
                i--;
            }
            sb.append(s.substring(i+1,j+1));
            j=i;
            i--;
        }
        return sb.toString();
    }
}

class Solution1 {
    public String reverseWords(String s) {
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }
    public StringBuilder removeSpace(String s){
        StringBuilder sb=new StringBuilder();
        int start=0;
        int end=s.length()-1;
        while(s.charAt(start)==' '){
            start++;
        }
        while(s.charAt(end)==' '){
            end--;
        }
        while(start<=end){
            char c=s.charAt(start);
            if(c!=' '||sb.charAt(sb.length()-1)!=' '){
                sb.append(c);
            }
            start++;
        }
        return sb;
    }
    public void reverseString(StringBuilder sb,int i,int j){
        while(i<j){
            char c=sb.charAt(i);
            sb.setCharAt(i,sb.charAt(j));
            sb.setCharAt(j,c);
            i++;
            j--;
        }

    }
    public void reverseEachWord(StringBuilder sb){
        int start=0;
        int end=1;
        while(start<sb.length()){
            if(end<sb.length()&&sb.charAt(end)!=' '){
                end++;
            }
            reverseString(sb,start,end-1);
            start=end+1;
            end=start+1;
        }
    }
}
