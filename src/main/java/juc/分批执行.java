package juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class 分批执行 {
    public static void main(String[] args) {
        // 创建线程池，大小为10
        ExecutorService executor = Executors.newFixedThreadPool(1);

        // 创建100个任务
        List<Task> tasks = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            tasks.add(new Task("Task " + i));
        }

        // 将任务分成10批执行
        for (int i = 0; i < 10; i++) {
            final int batchIndex = i;
            executor.submit(() -> {
                System.out.println("第"+batchIndex+"批次任务开始执行");
                // 执行批次中的所有任务
                for (int j = batchIndex * 10; j < (batchIndex + 1) * 10; j++) {
                    tasks.get(j).run();
                }
                System.out.println("第"+batchIndex+"批次任务执行完毕");
            });
        }

        // 关闭线程池
        executor.shutdown();
    }

    private static class Task implements Runnable {
        private final String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            // 任务的具体执行逻辑
            System.out.println(name + " is executing...");
        }
    }
}
