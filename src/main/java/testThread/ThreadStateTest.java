package testThread;

/**
 * @Author cxc
 * @Date 2023/6/24 5:19 PM
 * @Version 1.0
 * @Description:
 */

public class ThreadStateTest {
    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(() -> {
//        });
//        // 启动
//        thread.start();
//        System.out.println(thread.getState());

        Object obj = new Object();
        new Thread(() -> {
            synchronized (obj) {
                try {
                    System.out.println("1");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread thread = new Thread(() -> {
            synchronized (obj) {
                try {
                    System.out.println("2");
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

        Thread.sleep(1000);
        System.out.println(thread.getState());

    }
}
