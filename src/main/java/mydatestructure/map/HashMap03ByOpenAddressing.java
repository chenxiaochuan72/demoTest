package mydatestructure.map;

/**
 * @Author cxc
 * @Date 2023/9/4 8:31 PM
 * @Version 1.0
 * @Description:
 */

public class HashMap03ByOpenAddressing<K,V> implements Map<K,V>{
    private final Node<K,V>[] tab=new Node[8];
    @Override
    public void put(K key, V value) {
        int idx=key.hashCode()&(tab.length-1);
        if (tab[idx]==null){
            tab[idx]=new Node<>(key,value);
        }else {
            for (int i=idx;i<tab.length;i++){
                if(tab[i]==null){
                    tab[idx]=new Node<>(key, value);
                    break;
                }
            }
        }

    }

    @Override
    public V get(K key) {
        return null;
    }
    static class Node<K,V>{
        final K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
