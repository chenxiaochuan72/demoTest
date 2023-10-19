package 动态代理.test;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author cxc
 * @Date 2023/6/24 2:55 PM
 * @Version 1.0
 * @Description:
 */
@Slf4j
public class CglibProxy implements MethodInterceptor {
    public Object newInstall(Object object){
        return Enhancer.create(object.getClass(),this);
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("我被代理了 ");
        return methodProxy.invokeSuper(o,objects);
    }

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        UserApi userApi = (UserApi) cglibProxy.newInstall(new UserApi());
         userApi.queryUserInfo();
    }
}
