package dequeTest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        Deque<Integer> deque=new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.offer(3);

        System.out.println(deque.peekLast());
        Iterator<Integer> iterator = deque.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println("---");

        System.out.println(deque.pop());
        System.out.println("----------");
        System.out.println();
        System.out.println(deque.element());
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
        System.out.println(deque.peek());

        System.out.println(deque.poll());
        Iterator<Integer> iterator1 = deque.iterator();
        while (iterator1.hasNext()){
            System.out.print(iterator1.next()+" ");
        }
        System.out.println(deque.pop());

        Iterator<Integer> iterator2 = deque.iterator();
        while (iterator2.hasNext()){
            System.out.print(iterator2.next()+" ");
        }


    }
}
