package 设计模式.行为型模式.访问者模式;

import 设计模式.行为型模式.访问者模式.service.MinibusTargetService;

import java.util.Date;

/**
 * @Author cxc
 * @Date 2023/3/30 11:56 PM
 * @Version 1.0
 */
public class LotteryServiceImpl extends LotteryService{
    private MinibusTargetService minibusTargetService=new MinibusTargetService();
    @Override
    protected LotteryResult doDraw(String uId) {
        String lottery = minibusTargetService.lottery(uId);

        return new LotteryResult(uId,lottery,new Date());
    }
}
