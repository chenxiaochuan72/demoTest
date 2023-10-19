package 设计模式.结构型模式.适配器模式.design;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * MQ消息体适配类
 */
public class MQAdapter {
    public static RebateInfo filter(String strJson, Map<String,String> link) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException, ParseException {
        return filter(JSON.parseObject(strJson,Map.class),link);
    }

    public static RebateInfo filter(Map obj,Map<String,String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, ParseException {
        RebateInfo rebateInfo=new RebateInfo();
        for (String key: link.keySet()){
            Object val = obj.get(link.get(key));
            // 获取对应字段属性类型
            Class<?> type = RebateInfo.class.getDeclaredField(key).getType();
            if (type==String.class){
                val=val.toString();
            }else{
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                val = sdf.parse(val.toString());
            }
            RebateInfo.class.getMethod("set"
                            +key.substring(0,1).toUpperCase()
                            +key.substring(1),type)
                    .invoke(rebateInfo,val);

        }
        return rebateInfo;
    }
}
