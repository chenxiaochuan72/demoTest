package 设计模式.行为型模式.责任链模式;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author cxc
 * @Date 2023/3/30 8:47 PM
 * @Version 1.0
 */

/**
 * 链路抽象类定义
 */
@Slf4j
public abstract class AuthLink {
    protected SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    protected String levelUserId; // 级别⼈员ID
    protected String levelUserName; // 级别⼈员姓名
    private AuthLink next; // 责任链

    public AuthLink(String levelUserId, String levelUserName) {
        this.levelUserId = levelUserId;
        this.levelUserName = levelUserName;
    }

    public AuthLink next() {
        return next;
    }
    public AuthLink appendNext(AuthLink next) {
        this.next = next;
        return this;
    }
    public abstract AuthInfo doAuth(String uId, String orderId, Date authDate);
}
