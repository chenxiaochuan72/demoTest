package hashMapTest;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: cxc
 * @CreateTime: 2023-04-22  15:42
 * @Description: TODO
 * @Version: 1.0
 */
@Slf4j
public class STest {
    public static void main(String[] args) {
        // 初始化一组字符串
        List<String> list = new ArrayList<>();
        list.add("jlkk");
        list.add("lopi");
        list.add("小傅哥");
        list.add("e4we");
        list.add("alpo");
        list.add("yhjk");
        list.add("plop");
        String[] tab=new String[8];
        for (String key:list){
            int idx = key.hashCode() & (tab.length - 1);  // 计算索引位置
            System.out.println("key值："+key+"  hashCode:"+key.hashCode()+"  Idx"+idx);
            if (null==tab[idx]){
                tab[idx]=key;
                continue;
            }
            tab[idx]=tab[idx]+"->"+key;
        }
        System.out.println(JSON.toJSONString(tab));
    }
}
