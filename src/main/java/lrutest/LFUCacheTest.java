package lrutest;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cxc
 * @Date 2023/6/11 4:11 PM
 * @Version 1.0
 * @Description:
 */

public class LFUCacheTest {
}
class LFUCache{
    int minfreq,capacity;
    Map<Integer,Node> keyTable;
    Map<Integer,DoublyLinkedList> freqTable;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minfreq=0;
        keyTable=new HashMap<>();
        freqTable=new HashMap<>();
    }
    /**
     * get操作的具体逻辑大致是这样：
     *
     * 如果key不存在则返回-1
     * 如果key存在，则返回对应的value，同时:
     * 将元素的访问频率+1
     * 将元素从访问频率i的链表中移除，放到频率i+1的链表中
     * 如果频率i的链表为空，则从频率哈希表中移除这个链表
     */
    public int get(int key){
        if (capacity==0){
            return -1;
        }
        if (!keyTable.containsKey(key)){
            return -1;
        }
        // 获取该节点元素
        Node node = keyTable.get(key);
        int val = node.val;
        // 访问频次
        int freq = node.freq;
        freqTable.get(freq).remove(node);
        if (freqTable.get(freq).size==0){
            freqTable.remove(freq);
            if (minfreq==freq){
                minfreq+=1;
            }
        }
        DoublyLinkedList list = freqTable.getOrDefault(freq + 1, new DoublyLinkedList());
        list.addFirst(new Node(key,val,freq+1));
        freqTable.put(freq+1,list);
        keyTable.put(key,freqTable.get(freq+1).getHead());
        return val;
    }
    /**
     * 如果key已经存在，修改对应的value，并将访问频率+1
     * 将元素从访问频率i的链表中移除，放到频率i+1的链表中
     * 如果频率i的链表为空，则从频率哈希表中移除这个链表
     * 如果key不存在
     * 缓存超过最大容量，则先删除访问频率最低的元素，再插入新元素
     * 新元素的访问频率为1，如果频率哈希表中不存在对应的链表需要创建
     * 缓存没有超过最大容量，则插入新元素
     * 新元素的访问频率为1，如果频率哈希表中不存在对应的链表需要创建
     */

    public void put(int key,int value){
        if (capacity==0){
            return;
        }
        if (!keyTable.containsKey(key)){
            // 如果缓存超过最大容量
            if (keyTable.size()==capacity){
                // 获取访问频次最少的尾节点，删除
                Node tail = freqTable.get(minfreq).getTail();
                keyTable.remove(tail.key);
                freqTable.get(minfreq).remove(tail);
                if (freqTable.get(minfreq).size==0){
                    freqTable.remove(minfreq);
                }
            }
            DoublyLinkedList list = freqTable.getOrDefault(1, new DoublyLinkedList());
            list.addFirst(new Node(key,value,1));
            freqTable.put(1,list);
            keyTable.put(key,freqTable.get(1).getHead());
            minfreq=1;
        }else {
            Node node = keyTable.get(key);
            int freq = node.freq;
            freqTable.get(freq).remove(node);
            if (freqTable.get(freq).size==0){
                freqTable.remove(freq);
                if (minfreq==freq){
                    minfreq+=1;
                }
            }
            DoublyLinkedList list = freqTable.getOrDefault(freq + 1, new DoublyLinkedList());
            list.addFirst(new Node(key,value,freq+1));
            freqTable.put(freq+1,list);
            keyTable.put(key,freqTable.get(freq+1).getHead());
        }
    }
}

class Node{
    int key,val,freq;
    Node prev,next;
    Node() {
        this(-1, -1, 0);
    }

    public Node(int key, int val, int freq) {
        this.key = key;
        this.val = val;
        this.freq = freq;
    }
}

class DoublyLinkedList{
    Node head,tail;
    int size;

    public DoublyLinkedList() {
        head=new Node();
        tail=new Node();
        head.next=tail;
        tail.prev=head;
        this.size=0;
    }
    public void addFirst(Node node){
        Node next = head.next;
        node.prev=head;
        head.next=node;
        node.next=next;
        next.prev=node;
        size++;
    }
    public void remove(Node node){
        Node prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
        size--;
    }


    public Node getHead(){
        return head.next;
    }

    public Node getTail(){
        return tail.prev;
    }
}



