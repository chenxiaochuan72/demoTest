package 动态代理.jdk动态代理;

/**
 * @Author cxc
 * @Date 2023/5/30 10:40 PM
 * @Version 1.0
 * @Description:
 */

public class UserServiceImpl implements UserService {
    @Override
    public void selectUser1() {
        System.out.println("selectUser1");
    }

    @Override
    public void selectUser2() {
        System.out.println("selectUser2");
    }

    @Override
    public void selectUser3() {
        System.out.println("selectUser2");
    }
}
