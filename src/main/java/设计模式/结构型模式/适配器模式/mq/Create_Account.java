package 设计模式.结构型模式.适配器模式.mq;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Create_Account {
    private String number; // 开户编号
    private String address; // 开户地
    private Date accountDate; // 开户时间
    private String desc;


}
