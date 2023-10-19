package 设计模式.创建型模式.原型模式.design02.util;

import java.util.*;

public class TopicRandomUtil {
    /**
     * 乱序Map元素，记录对应答案key
     * @param option 题⽬
     * @param key 答案
     * @return Topic 乱序后 {A=c., B=d., C=a., D=b.}
     */
    public static Topic random(Map<String,String> option, String key){
        Set<String> keySet = option.keySet();
        List<String> keyList=new ArrayList<>(keySet);
        Collections.shuffle(keyList);
        HashMap<String,String> optionNew=new HashMap<String,String>();
        int idx=0;
        String keyNew="";
        for (String next:keyList){
            String randomKey = keyList.get(idx++);
            if(key.equals(randomKey)){
                keyNew=randomKey;
            }
            optionNew.put(randomKey,option.get(next));
        }
        return new Topic(optionNew,keyNew);
    }
}
