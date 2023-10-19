package 动态代理.cglib代理;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author cxc
 * @Date 2023/5/30 10:59 PM
 * @Version 1.0
 * @Description:
 */

public class CglibMethodInterceptor implements MethodInterceptor {
    /**
     * @param o           被代理的对象（需要增强的对象）
     * @param method      被拦截的方法（需要增强的方法）
     * @param objects        方法入参
     * @param methodProxy 用于调用原始方法
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("被代理的对象"+o.getClass());
        System.out.println("被拦截的方法"+method.getName());
        System.out.println("before method"+method.getName());
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("after method " + method.getName());
        return object;
    }
}
