package test;

import java.net.URL;

/**
 * @Author cxc
 * @Date 2023/6/28 4:13 PM
 * @Version 1.0
 * @Description:
 */

public class PrintClassLoaderTree extends ClassLoader{
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return super.loadClass(name, resolve);
    }

    @Override
    protected URL findResource(String name) {
        return super.findResource(name);
    }
}
