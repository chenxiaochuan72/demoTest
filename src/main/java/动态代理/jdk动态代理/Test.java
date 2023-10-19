package 动态代理.jdk动态代理;

import java.lang.reflect.Proxy;

/**
 * @Author cxc
 * @Date 2023/5/30 10:42 PM
 * @Version 1.0
 * @Description:
 */

public class Test {
    public static void main(String[] args) {
        UserService userService=new UserServiceImpl();
//        UserService proxy = (UserService) JdkProxyFactory.getProxy(userService);
//        proxy.selectUser1();
        JdkInvocationHandler handler = new JdkInvocationHandler(userService, true);

        UserService o = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                handler);
        o.selectUser1();
        o.selectUser2();
    }
}
