package 设计模式.结构型模式.代理模式.agent;

/**
 * @Author cxc
 * @Date 2023/3/29 9:11 PM
 * @Version 1.0
 */
public interface IUserDao {
    @Select("select userName from user where id=#{id}")
    public String queryUserInfo(String uId);
}
