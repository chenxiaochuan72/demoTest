package testThread;

import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Dispatcher;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;

/**
 * @Author cxc
 * @Date 2023/6/24 9:16 PM
 * @Version 1.0
 * @Description:
 */

public class MateSpaceTest {
    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(100000);

        ClassLoadingMXBean loadingBean = ManagementFactory.getClassLoadingMXBean();
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MateSpaceTest.class);
            enhancer.setCallbackTypes(new Class[]{Dispatcher.class, MethodInterceptor.class});
            enhancer.setCallbackFilter(new CallbackFilter() {
                @Override
                public int accept(Method method) {
                    return 1;
                }
                @Override
                public boolean equals(Object obj) {
                    return super.equals(obj);
                }
            });
            System.out.println(enhancer.createClass().getName() + loadingBean.getTotalLoadedClassCount() + loadingBean.getLoadedClassCount() + loadingBean.getUnloadedClassCount());
        }
    }

}
