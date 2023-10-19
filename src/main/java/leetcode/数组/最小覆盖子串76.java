package leetcode.数组;

import java.util.HashMap;

/**
 * @Author cxc
 * @Date 2023/8/4 5:38 PM
 * @Version 1.0
 * @Description:
 */

public class 最小覆盖子串76 {
    public static void main(String[] args) {
        最小覆盖子串76.minWindow("ADOBECODEBANC","ABC");
        
    }
    public static String minWindow(String s, String t) {
        char[] cs=s.toCharArray();
        char[] ct=t.toCharArray();
        // needs是需要的字符和数量，window记录窗口中有效的字符和数量
        HashMap<Character,Integer> needs=new HashMap<>();
        HashMap<Character,Integer> windows=new HashMap<>();
        // valid 变量表示窗口中满足 need 条件的字符个数
        int valid=0;
        int left=0,right=0;
        // 记录最小覆盖子串的起始索引及长度
        int start=0,len=Integer.MAX_VALUE;
        for(char c:ct){
            needs.put(c,needs.getOrDefault(c,0)+1);
        }
        while(right<cs.length){
            char c=cs[right];
            right++;
            if(needs.containsKey(c)){
                windows.put(c,windows.getOrDefault(c,0)+1);
                if(windows.get(c).equals(needs.get(c))){
                    valid++;
                }
            }
            while(valid==needs.size()){
                if(right-left<len){
                    start=left;
                    len=right-left;
                }
                char d=cs[left];
                left++;
                if(needs.containsKey(d)){
                    windows.put(d,windows.get(d)-1);
                    if(windows.get(d)<Integer.valueOf(needs.get(d))){
                        valid--;
                    }
                }
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
    }
}
