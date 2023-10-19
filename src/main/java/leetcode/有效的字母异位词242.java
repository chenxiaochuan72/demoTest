package leetcode;

/**
 * @Author cxc
 * @Date 2023/8/10 10:14 PM
 * @Version 1.0
 * @Description:
 */

public class 有效的字母异位词242 {
    public static void main(String[] args) {
        isAnagram("anagram","nagaram");
    }
    public static boolean isAnagram(String s, String t) {
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            arr[c-'a']++;
        }
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            arr[c-'a']--;
        }
        for (int i : arr) {
            if (i!=0){
                return false;
            }
        }
        return true;
    }
}
