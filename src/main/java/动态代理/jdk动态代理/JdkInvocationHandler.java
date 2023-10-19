package 动态代理.jdk动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author cxc
 * @Date 2023/5/30 10:40 PM
 * @Version 1.0
 * @Description:
 */

public class JdkInvocationHandler implements InvocationHandler {
    private final Object object;

    private boolean dynamicFlag; // 标志是否进行动态实现

    public JdkInvocationHandler(Object object, boolean dynamicFlag) {
        this.object = object;
        this.dynamicFlag = dynamicFlag;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("selectUser1")&&dynamicFlag){
            Object invoke = method.invoke(object, args);
            return invoke;
        }else {
            System.out.println("222");
            Object invoke = method.invoke(object, args);
            return invoke;
        }
    }
}
