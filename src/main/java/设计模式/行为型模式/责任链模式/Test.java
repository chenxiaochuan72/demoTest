package 设计模式.行为型模式.责任链模式;

import lombok.extern.slf4j.Slf4j;
import 设计模式.行为型模式.责任链模式.impl.Level1AuthLink;
import 设计模式.行为型模式.责任链模式.impl.Level2AuthLink;
import 设计模式.行为型模式.责任链模式.impl.Level3AuthLink;

import java.text.ParseException;
import java.util.Date;

/**
 * @Author cxc
 * @Date 2023/3/30 9:03 PM
 * @Version 1.0
 */
@Slf4j
public class Test {
    public static void main(String[] args) throws ParseException {
        AuthLink authLink=new Level3AuthLink("1000013","王工")
                .appendNext(new Level2AuthLink("1000012", "张经理")
                .appendNext(new Level1AuthLink("1000011", "段总")));
        log.info("测试结果：{}", authLink.doAuth("⼩傅哥", "1000998004813441", new Date()).toString());

        AuthService.auth("1000013", "1000998004813441");
        log.info("测试结果：{}", "模拟三级负责⼈审批，王⼯");
        log.info("测试结果：{}", authLink.doAuth("⼩傅哥", "1000998004813441", new Date()).toString());

        AuthService.auth("1000012", "1000998004813441");
        log.info("测试结果：{}", "模拟⼆级负责⼈审批，张经理");
        log.info("测试结果：{}", authLink.doAuth("⼩傅哥", "1000998004813441", new Date()).toString());

        // 模拟⼀级负责⼈审批
        AuthService.auth("1000011", "1000998004813441");
        log.info("测试结果：{}", "模拟⼀级负责⼈审批，段总");
        log.info("测试结果：{}", authLink.doAuth("⼩傅哥", "1000998004813441", new Date()).toString());
    }
}
