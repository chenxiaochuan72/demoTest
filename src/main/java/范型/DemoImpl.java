package 范型;

/**
 * @Author cxc
 * @Date 2023/5/30 11:35 PM
 * @Version 1.0
 * @Description:
 */

public class DemoImpl implements Demo22<String>{
    @Override
    public String doMethod() {
        System.out.println("实现接口");
        return "s";
    }
}
 interface Demo22 <T>{
    public T doMethod();
}

