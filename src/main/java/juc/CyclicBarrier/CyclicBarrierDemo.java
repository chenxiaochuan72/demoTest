package juc.CyclicBarrier;

import java.text.SimpleDateFormat;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author cxc
 * @Date 2023/6/3 5:20 PM
 * @Version 1.0
 * @Description:
 */

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        SimpleDateFormat format=new SimpleDateFormat("sdf");
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("凑齐3人了，出发！");
            }
        });
        for (int i=0;i<9;i++){
            new Thread(new Task(i+1,cyclicBarrier)).start();
        }
    }

    static class Task implements Runnable {
        private int id;

        private CyclicBarrier cyclicBarrier;

        public Task(int id, CyclicBarrier cyclicBarrier) {

            this.id = id;

            this.cyclicBarrier = cyclicBarrier;

        }

        @Override
        public void run() {
            System.out.println("同学" + id + "现在从大门出发，前往自行车驿站");
            try {
                Thread.sleep((long) (Math.random() * 10000));
                System.out.println("同学" + id + "到了自行车驿站，开始等待其他人到达");
                cyclicBarrier.await();
                System.out.println("同学" + id + "开始骑车");
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
