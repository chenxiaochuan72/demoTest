package leetcode;


import java.util.*;

public class 栈的压入弹出序列 {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<Integer>();
        int i=0;
        for(int num:pushed){
            stack.push(num);
            while(!stack.isEmpty()
                    &&
                    stack.peek()==popped[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Deque<Integer> queue=new LinkedList<>();
        queue.add(1);
        queue.add(2);
        System.out.println(queue.poll());
        Deque<Integer> list=new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.remove());
        Deque<Character> path=new LinkedList<>();
        path.add('a');
        path.add('b');
        List<String> list1=new ArrayList<>();
        list1.toArray();

        Deque<Character> fd =new LinkedList<>();
        fd.add('a');
        fd.add('2');

    }
}

