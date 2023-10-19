//package 动态代理.jdk动态代理;
//
//import java.lang.reflect.Proxy;
//
///**
// * @Author cxc
// * @Date 2023/5/30 10:48 PM
// * @Version 1.0
// * @Description:
// */
//
//public class JdkProxyFactory {
//    public static Object getProxy(Object target){
//        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
//                target.getClass().getInterfaces(),
//                new JdkInvocationHandler(target));
//    }
//}
