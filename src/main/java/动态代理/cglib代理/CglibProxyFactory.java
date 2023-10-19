package 动态代理.cglib代理;

import net.sf.cglib.proxy.Enhancer;

/**
 * @Author cxc
 * @Date 2023/5/30 11:01 PM
 * @Version 1.0
 * @Description:
 */

public class CglibProxyFactory {

    public static Object getProxy(Class<?> clazz){
        Enhancer enhancer=new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new CglibMethodInterceptor());
        return enhancer.create();
    }
}
