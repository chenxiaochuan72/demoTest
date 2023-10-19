package 设计模式.结构型模式.代理模式;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import 设计模式.结构型模式.代理模式.agent.IUserDao;

/**
 * @Author cxc
 * @Date 2023/3/29 9:24 PM
 * @Version 1.0
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        IUserDao userDao = context.getBean("userDao", IUserDao.class);
        String res = userDao.queryUserInfo("100001");
        log.info("测试结果：{}",res);
    }
}
