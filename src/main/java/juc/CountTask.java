package juc;

import java.util.concurrent.RecursiveTask;

/**
 * @Author: cxc
 * @CreateTime: 2023-04-15  14:58
 * @Description: TODO
 * @Version: 1.0
 */
public class CountTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD=2;
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum=0;
        boolean canCompute=(end-start)<=THRESHOLD;
        if (canCompute){
            for (int i=start;i<=end;i++){
                sum+=i;
            }
        }else {
            int middle=(start+end)/2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask= new CountTask(middle + 1, end);
            leftTask.fork();
            rightTask.fork();
            int leftResult=leftTask.join();
            int rightResult=rightTask.join();
            sum=leftResult+rightResult;
        }
        return sum;
    }

}
