package juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class BatchTaskExecutor {
    public static void main(String[] args) throws InterruptedException {

        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // 定义信号量，初始值为1
        Semaphore semaphore = new Semaphore(1);

        // 分批提交任务
        for (int i = 0; i < 10; i++) {
            final int batchNumber = i + 1;
            // 获取信号量许可
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    ExecutorService service = Executors.newFixedThreadPool(10);
                    for (int j=0;j<10;j++){
                        final int sum=j+1;
                        service.execute(()->{
                            try {
                                System.out.println("第"+batchNumber+"批次任务"+"第"+sum+"任务"+"开始执行");
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        });
                    }
                    service.shutdown();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // 释放信号量许可
                    semaphore.release();
                }
            });
        }

        // 关闭线程池
        executorService.shutdown();
    }

}
