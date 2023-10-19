package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author: cxc
 * @CreateTime: 2023-04-03  14:52
 * @Description: TODO
 * @Version: 1.0
 */
public class JsonTest {
    public static void main(String[] args) {
        String result="{\n" +
                "    \"code\": \"43\",\n" +
                "    \"message\": \"voluptate in in qui mollit\",\n" +
                "    \"data\": {\n" +
                "        \"citizentype\": \"ad eiusmod non in Ut\",\n" +
                "        \"expiredate\": \"2004-10-27\",\n" +
                "        \"score\": \"et\"\n" +
                "    },\n" +
                "    \"seqNo\": \"qui\"\n" +
                "}";
        JSONObject jsonObject = JSON.parseObject(result);
        System.out.println(jsonObject.getString("code"));
    }
}
