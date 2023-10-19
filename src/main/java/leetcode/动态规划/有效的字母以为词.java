package leetcode.动态规划;

public class 有效的字母以为词 {
    public static boolean isAnagram(String s, String t) {
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        for(int j=0;j<t.length();j++){
            arr[t.charAt(j)-'a']--;
        }

        for(int a:arr){
            if(a!=0){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(isAnagram("a", "a"));
    }
}
