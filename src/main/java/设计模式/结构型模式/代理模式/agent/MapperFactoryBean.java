package 设计模式.结构型模式.代理模式.agent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author cxc
 * @Date 2023/3/29 8:59 PM
 * @Version 1.0
 */
@Slf4j
public class MapperFactoryBean<T> implements FactoryBean<T> {
    private Class<T> mapperInterface;

    public MapperFactoryBean(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public T getObject() throws Exception {
        InvocationHandler handler=((proxy, method, args) -> {
            Select select = method.getAnnotation(Select.class);
            log.info("SQL：{}",select.value().replace("#{id}",args[0].toString()));
            return args[0]+",⼩傅哥,bugstack.cn - 沉淀、分享、成⻓，让⾃⼰和他⼈都能有所收获！";
        });

        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{mapperInterface},handler);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
