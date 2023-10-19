package test;

/**
 * @Author cxc
 * @Date 2023/6/24 3:39 PM
 * @Version 1.0
 * @Description:
 */

public class ThreadTest {
    private static volatile int counter=0;

    public static synchronized void add(){
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<10;i++){
            new Thread(()->{
                for (int j=0;j<10000;j++){
                    add();
                }
            }).start();
        }

        Thread.sleep(5000);

        System.out.println(counter);
    }
}
