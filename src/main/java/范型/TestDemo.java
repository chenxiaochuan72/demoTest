package 范型;

import java.util.PriorityQueue;

/**
 * @Author cxc
 * @Date 2023/5/30 11:18 PM
 * @Version 1.0
 * @Description:
 */

class MyArray {
    public Object[] objects = new Object[10];

    public void set(int pos, Object val) {
        objects[pos] = val;
    }

    public Object get(int pos) {
        return objects[pos];
    }
}

public class TestDemo {
    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        myArray.set(0, "bit");
        myArray.set(1, 10);;

        // String str = myArray.get(0); // 编译报错
        String str = (String) myArray.get(0);
        System.out.println(str);
    }

    public static void main1(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        // 每放一个元素 都得保证当前的堆 是大堆 或者是小堆
        priorityQueue.offer(1);
        priorityQueue.offer(2);
        priorityQueue.offer(3);

        System.out.println(priorityQueue.poll()); // 1 ->默认是小堆
        System.out.println(priorityQueue.peek()); // 2
    }
}


