package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class 有效括号 {
    static class Solution {
        public static boolean isValid(String s) {
            Deque<Character> stack=new LinkedList<>();
            char ch;
            for(int i=0;i<s.length();i++){
                ch=s.charAt(i);
                if('('==ch){
                    stack.push(')');
                }else if('{'==ch){
                    stack.push('}');
                }else if('['==ch){
                    stack.push(']');
                }else if(stack.isEmpty()||ch!=stack.peek()){
                    return false;
                }else{
                    stack.pop();
                }
            }
            return stack.isEmpty();
        }
        public static int longestValidParentheses(String s) {
            int maxans = 0;
            Deque<Integer> stack = new LinkedList<Integer>();
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        maxans = Math.max(maxans, i - stack.peek());
                    }
                }
            }
            return maxans;
        }

    }


    public static void main(String[] args) {
        Solution.longestValidParentheses(")()())");
    }
}
