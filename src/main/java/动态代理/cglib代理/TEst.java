package 动态代理.cglib代理;

/**
 * @Author cxc
 * @Date 2023/5/30 11:02 PM
 * @Version 1.0
 * @Description:
 */

public class TEst {
    public static void main(String[] args) {
        UserService proxy = (UserService) CglibProxyFactory.getProxy(UserService.class);
        proxy.selectUser1();
    }
}
