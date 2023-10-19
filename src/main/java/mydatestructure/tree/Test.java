package mydatestructure.tree;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @Author cxc
 * @Date 2023/9/1 5:21 PM
 * @Version 1.0
 * @Description:
 */

public class Test {
    public final static Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        Trie trie = new Trie(); // 存入
        trie.insert("bat", "大厂");
        trie.insert("batch", "批量");
        trie.insert("bitch", "彪子");
        trie.insert("battle", "战斗");
        logger.info(trie.toString());
        // 检索
        List<String> trieNodes = trie.searchPrefix("ba");
        logger.info("测试结果：{}", JSON.toJSONString(trieNodes));
    }
}
