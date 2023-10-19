package mydatestructure.map;

/**
 * @Author cxc
 * @Date 2023/9/2 5:33 PM
 * @Version 1.0
 * @Description:
 */

public interface Map <K,V>{
    void put(K key,V value);
    V get(K key);
}
