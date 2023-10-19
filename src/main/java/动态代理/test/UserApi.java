package 动态代理.test;

/**
 * @Author cxc
 * @Date 2023/6/24 2:46 PM
 * @Version 1.0
 * @Description:
 */

public class UserApi implements IUserApi{
    @Override
    public void queryUserInfo() {
        System.out.println("queryUserInfo");
    }
}
