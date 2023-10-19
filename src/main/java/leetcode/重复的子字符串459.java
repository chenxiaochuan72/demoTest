package leetcode;

public class 重复的子字符串459 {
    public static boolean repeatedSubstringPattern(String s) {
        int len=s.length();
        int[] next=new int[s.length()];
        getNext(next,s);
        if(next[len-1]>0&&len%(len-next[len-1])==0){
            return true;
        }
        return false;


    }
    public static void getNext(int[] next,String needle){
        // j 前缀末尾
        // i 后缀末尾
        int j=0;
        next[0]=0;
        for(int i=1;i<needle.length();i++){
            while(j>0&&needle.charAt(i)!=needle.charAt(j)){
                j=next[j-1];
            }
            if(needle.charAt(j)==needle.charAt(i)){
                j++;
            }
            next[i]=j;
        }
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
    }

}
