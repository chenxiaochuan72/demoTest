package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class 逆波兰表达式 {
    public static void main(String[] args) {
        Test test=new Test();
        String[] str={"2","1","+","3","*"};
        System.out.println(test.evalRPN(str));
        Queue<int[]> queue=new PriorityQueue<>((par1,par2)->par1[1]-par2[1]);
    }
}
class Test {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque=new ArrayDeque<>();
        for(String str:tokens){
            if("+".equals(str)){
                deque.push(deque.pop()+deque.pop());
            }else if("-".equals(str)){
                deque.push(-deque.pop()+deque.pop());
            }else if("*".equals(str)){
                deque.push(deque.pop()*deque.pop());
            }else if("/".equals("str")){
                int temp1=deque.pop();
                int temp2=deque.pop();
                deque.push(temp2 / temp1);
            }else{
                deque.push(Integer.valueOf(str));
            }
        }
        return deque.pop();

    }
}