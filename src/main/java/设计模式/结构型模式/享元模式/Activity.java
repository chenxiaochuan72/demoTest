package 设计模式.结构型模式.享元模式;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Activity implements Serializable {
    private Long id; // 活动ID
    private String name; // 活动名称
    private String desc; // 活动描述

    private Date startTime; // 开始时间
    private Date stopTime; // 结束时间
    private Stock stock; // 活动库存
}
