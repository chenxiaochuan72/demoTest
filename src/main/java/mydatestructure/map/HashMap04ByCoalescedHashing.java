package mydatestructure.map;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author cxc
 * @Date 2023/9/5 11:20 PM
 * @Version 1.0
 * @Description:
 */
@Slf4j
public class HashMap04ByCoalescedHashing<K,V> implements Map<K,V> {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap04ByCoalescedHashing<>();
        map.put("01", "花花");
        map.put("05", "豆豆");
        log.info("碰撞前 key：{} value：{}", "01", map.get("01"));
        // 下标碰撞
        map.put("09", "蛋蛋");
        map.put("12", "苗苗");
        log.info("碰撞前 key：{} value：{}", "01", map.get("01"));
    }
    private final Node<K,V>[] tab=new Node[8];
    @Override
    public void put(K key, V value) {
        int idx=key.hashCode()&(tab.length-1);
        if (tab[idx]==null){
            tab[idx]=new Node<>(key, value);
            return;
        }
        int cursor=tab.length-1;
        while (tab[cursor]!=null&&tab[cursor].key!=null){
            --cursor;
        }
        tab[cursor]=new Node<>(key, value);
        while (tab[idx].idxOfNext!=0){
            idx=tab[idx].idxOfNext;
        }
        tab[idx].idxOfNext=cursor;
    }

    @Override
    public V get(K key) {
        int idx=key.hashCode()&(tab.length-1);
        while (tab[idx].key!=key){
            idx=tab[idx].idxOfNext;
        }
        return tab[idx].value;

    }
    static class Node<K, V> {
        final K key;
        V value;
        int idxOfNext;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
