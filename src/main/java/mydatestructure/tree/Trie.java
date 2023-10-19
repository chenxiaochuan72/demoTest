package mydatestructure.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author cxc
 * @Date 2023/9/1 5:00 PM
 * @Version 1.0
 * @Description:
 */

public class Trie {
    public final static TrieNode wordsTree = new TrieNode();

    public void insert(String words, String explain) {
        TrieNode root = wordsTree;
        char[] chars = words.toCharArray();
        for (char c : chars) {
            int idx = c - 'a';
            if (root.slot[idx] == null) {
                root.slot[idx] = new TrieNode();
            }
            root = root.slot[idx];
            root.c = c;
            root.prefix++;
        }
        root.explain = explain;
        root.isWord = true;
    }

    public List<String> searchPrefix(String prefix) {
        TrieNode root = wordsTree;
        char[] chars = prefix.toCharArray();
        StringBuilder cache = new StringBuilder();
        // 精准匹配：根据前置精准查找
        for (char c : chars) {
            int idx = c - 'a';
            if (idx > root.slot.length || idx < 0 || root.slot[idx] == null) {
                return Collections.emptyList();
            }
            cache.append(c);
            root = root.slot[idx];
        }
        // 模糊匹配：根据前缀的最后一个单词，递归遍历所有的单词
        ArrayList<String> list = new ArrayList<>();
        if (root.prefix != 0) {
            for (int i = 0; i < root.slot.length; i++) {
                if (root.slot[i] != null) {
                    char c = (char) (i + 'a');
                    collect(root.slot[i], String.valueOf(cache) + c, list, 15);
                    if (list.size() >= 15) {
                        return list;
                    }
                }
            }
        }
        return list;
    }

    protected void collect(TrieNode trieNode, String pre, List<String> queue, int resultLimit) {
        // 找到单词
        if (trieNode.isWord){
            trieNode.word=pre;
        }
        queue.add(trieNode.word+"->"+trieNode.explain);
        if (queue.size()>=resultLimit){
            return;
        }
        // 递归调用，查找单词
        for (int i = 0; i < trieNode.slot.length; i++) {
            char c = (char) ('a' + i);
            if (trieNode.slot[i] != null) {
                collect(trieNode.slot[i], pre + c, queue, resultLimit);
            }
        }
    }
}
