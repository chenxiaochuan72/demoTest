//package test;
//
//import java.text.SimpleDateFormat;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * @Author: cxc
// * @CreateTime: 2023-04-04  20:07
// * @Description: TODO
// * @Version: 1.0
// */
//public class ThreadLocalTest {
//    private static ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//    public static void main(String[] args) {
//        ReentrantLock lock=new ReentrantLock();
//        lock.lock();
//
//
//    }
//
//}
// class InstanceFactory {
//    private static class InstanceHolder {
//        public static Instance instance = new Instance();
//    }
//    public static Instance getInstance() {
//        return InstanceHolder.instance ; // 这里将导致InstanceHolder类被初始化
//    }
//}
