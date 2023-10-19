package testThread;

/**
 * @Author cxc
 * @Date 2023/6/24 3:49 PM
 * @Version 1.0
 * @Description:
 */

public class Singleton {
    private Singleton(){

    }
    private volatile static Singleton singleton;

    public Singleton getInstance(){
        if (singleton==null){
            synchronized (Singleton.class){
                if (singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }
}
