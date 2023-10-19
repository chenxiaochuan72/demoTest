package test;

import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Demo03 {
    Byte[] bytes = new Byte[1 * 1024 * 1024];

    public static void main(String[] args) throws ParseException {
        Deque<Integer> deque = new ArrayDeque<Integer>(10);
        deque.push(1);
        deque.push(2);
        deque.push(3);
        deque.push(4);

        System.out.println(Arrays.toString(deque.toArray()));
    }
}
