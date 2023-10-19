package leetcode.字符串;

/**
 * @Author cxc
 * @Date 2023/9/1 3:04 PM
 * @Version 1.0
 * @Description:
 */

public class KMP {
    public static void main(String[] args) {
        new Solution12().strStr("aabaaabaaac","aabaaac");
    }
}
class Solution12 {
    public int strStr(String haystack, String needle) {
        if(needle==null||needle.length()==0){
            return 0;
        }
        int[] next=new int[needle.length()];
        getNext(needle,next);
        int j=0;
        for(int i=0;i<haystack.length();i++){
            while(j>0&&haystack.charAt(i)!=needle.charAt(j)){
                j=next[j-1];
            }
            if(haystack.charAt(i)==needle.charAt(j)){
                j++;
            }
            if(j==needle.length()){
                return (i-needle.length()+1);
            }
        }
        return -1;

    }
    // next数组含义以i结尾字符串的最长公共前后缀
    public void getNext(String needle,int[] next){
        // j 前缀末尾
        // i 后缀末尾
        // 前缀是指不包含最后一个字符的所有以第一个字符开头的连续子串；
        // 后缀是指不包含第一个字符的所有以最后一个字符结尾的连续子串。）
        int j=0;
        next[0]=0;
        for(int i=1;i<next.length;i++){
            while(j>0&&needle.charAt(i)!=needle.charAt(j)){
                j=next[j-1];
            }
            if(needle.charAt(i)==needle.charAt(j)){
                j++;
            }
            next[i]=j;

        }
    }
}