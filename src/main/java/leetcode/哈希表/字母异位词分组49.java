package leetcode.哈希表;

import java.util.*;

/**
 * @Author cxc
 * @Date 2023/8/15 12:50 AM
 * @Version 1.0
 * @Description:
 */

public class 字母异位词分组49 {
    public static void main(String[] args) {
        字母异位词分组49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] array=str.toCharArray();
            Arrays.sort(array);
            String key=new String(array);
            List<String> list=map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(str,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
