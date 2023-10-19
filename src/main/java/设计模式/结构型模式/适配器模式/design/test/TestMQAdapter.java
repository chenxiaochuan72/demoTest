package 设计模式.结构型模式.适配器模式.design.test;

import com.alibaba.fastjson.JSON;
import 设计模式.结构型模式.适配器模式.design.MQAdapter;
import 设计模式.结构型模式.适配器模式.design.RebateInfo;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.HashMap;

public class TestMQAdapter {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException, ParseException {
        String json="{\"accountDate\":\"2022-03-02 12:30:30\",\"address\":\"河北省.廊坊" +
                "市.⼴阳区.⼤学⾥职业技术学院\",\"desc\":\"在校开户\",\"number\":\"100001\"}";
        HashMap<String, String> link01 = new HashMap<String, String>();
        link01.put("userId", "number");
        link01.put("bizId", "number");
        link01.put("bizTime", "accountDate");
        link01.put("desc", "desc");
        RebateInfo rebateInfo01 = MQAdapter.filter(json, link01);
        System.out.println("mq.create_account(适配前)" +
                json);
        System.out.println("mq.create_account(适配后)" +
                JSON.toJSONString(rebateInfo01));
        System.out.println();

        String orderMq="{\"createOrderTime\":\"2022-03-02 12:30:30\",\"orderId\":\"100000890193847111\",\"sku\":\"1092\n" +
                "8092093111123\",\"uid\":\"100001\"}";
        HashMap<String, String> link02 = new HashMap<String, String>();
        link02.put("userId", "uid");
        link02.put("bizId", "orderId");
        link02.put("bizTime", "createOrderTime");
        RebateInfo rebateInfo02 = MQAdapter.filter(orderMq.toString(),
                link02);
        System.out.println("mq.orderMq(适配前)" + orderMq.toString());
        System.out.println("mq.orderMq(适配后)" +
                JSON.toJSONString(rebateInfo02));
    }
}
