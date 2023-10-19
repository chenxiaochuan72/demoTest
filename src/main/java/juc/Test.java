package juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {
        int[][] arr={{1,2,3},{1,2,3}};
        System.out.println(arr.length);
        System.out.println(arr[0].length);

        ReentrantLock reentrantLock=new ReentrantLock();
        ExecutorService service = Executors.newFixedThreadPool(1);

    }
}
