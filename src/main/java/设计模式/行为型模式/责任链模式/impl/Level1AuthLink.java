package 设计模式.行为型模式.责任链模式.impl;

import 设计模式.行为型模式.责任链模式.AuthInfo;
import 设计模式.行为型模式.责任链模式.AuthLink;
import 设计模式.行为型模式.责任链模式.AuthService;

import java.util.Date;

/**
 * @Author cxc
 * @Date 2023/3/30 8:47 PM
 * @Version 1.0
 */
public class Level1AuthLink extends AuthLink {
    public Level1AuthLink(String levelUserId, String levelUserName) {
        super(levelUserId, levelUserName);
    }

    @Override
    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(levelUserId, orderId);
        if (null==date){
            return new AuthInfo("0001","单号：",orderId,"状态：待一级审批负责人", levelUserName);
        }
        AuthLink  next=super.next();
        if (null==next){
            return new AuthInfo("0000", "单号：", orderId, " 状态：⼀级审批完 成负责⼈", " 时间：", f.format(date), " 审批⼈：", levelUserName);
        }
        return next.doAuth(uId, orderId, authDate);
    }
}
