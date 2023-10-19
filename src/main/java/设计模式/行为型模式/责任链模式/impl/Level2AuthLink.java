package 设计模式.行为型模式.责任链模式.impl;

import 设计模式.行为型模式.责任链模式.AuthInfo;
import 设计模式.行为型模式.责任链模式.AuthLink;
import 设计模式.行为型模式.责任链模式.AuthService;

import java.text.ParseException;
import java.util.Date;

/**
 * @Author cxc
 * @Date 2023/3/30 8:48 PM
 * @Version 1.0
 */
public class Level2AuthLink extends AuthLink {
    private Date beginDate = f.parse("2023-03-01 00:00:00");
    private Date endDate = f.parse("2023-04-02 23:59:59");

    public Level2AuthLink(String levelUserId, String levelUserName) throws ParseException {
        super(levelUserId, levelUserName);
    }

    @Override
    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(levelUserId, orderId);
        if (null == date) {
            return new AuthInfo("0001", "单号：", orderId, " 状态：待⼆级审批 负责⼈ ", levelUserName);
        }
        AuthLink next = super.next();
        if (null == next) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：⼆级审批完 成负责⼈", " 时间：", f.format(date), " 审批⼈：", levelUserName);
        }
        if (authDate.before(beginDate) || authDate.after(endDate)) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：⼆级审批完 成负责⼈", " 时间：", f.format(date), " 审批⼈：", levelUserName);
        }
        return next.doAuth(uId, orderId, authDate);
    }
}
