package 动态代理.test;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author cxc
 * @Date 2023/6/24 2:49 PM
 * @Version 1.0
 * @Description:
 */
@Slf4j
public class JDKProxy {
    public static <T> T getProxy(Class clazz){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName()+"你被代理了，By JDKProxy！");
                return "小傅哥，公众号：bugstack虫洞栈 | 沉淀、分享、成长，让自己和他人都能有所收获！";

            }
        });
    }

    public static void main(String[] args) {
        IUserApi userApi = JDKProxy.getProxy(IUserApi.class);
        userApi.queryUserInfo();

    }
}
