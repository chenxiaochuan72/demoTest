package testThread;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author cxc
 * @Date 2023/6/24 3:45 PM
 * @Version 1.0
 * @Description:
 */
@Slf4j
public class test {
    public static boolean sign=false;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            int i = 0;
            while (!sign) {
                i++;
                add(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sign = true;
            log.info("vt.sign = true  while (!sign)");
        });
        thread1.start();
        thread1.start();
        thread2.start();
    }


    public static synchronized int add(int i){
        return i+1;
    }
}
