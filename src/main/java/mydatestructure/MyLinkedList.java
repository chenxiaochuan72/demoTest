package mydatestructure;

/**
 * @Author cxc
 * @Date 2023/8/29 6:20 PM
 * @Version 1.0
 * @Description:
 */

public class MyLinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;
    private static class Node<E>{
        E item;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev,E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
    /**
     * 头插节点
     * 头插的操作流程，先把头节点记录下来。之后创建一个新的节点，新的节点构造函
     * 数的头节点入参为 null，通过这样的方式构建出一个新的头节点。
     * 原来的头结点，设置 f.prev 连接到新的头节点，这样的就可以完成头插的操作了。
     * 另外如果原来就没有头节点，头节点设置为新的节点即可。最后记录当前链表中节 的数量，
      */
    void linkFist(E e){
        final Node<E> f=first;
        final Node<E> newNode=new Node<>(null,e,f);
        first=newNode;
        if (f==null){
            last=newNode;
        }else {
            f.prev=newNode;
        }
    }
    void linkLast(E e){
        final Node<E> l=last;
        final Node<E> newNode=new Node<>(l,e,null);
        last=newNode;
        if (l==null){
            first=newNode;
        }else{
            l.next=newNode;
        }
    }
    E unlink(Node<E> x){
        final E element=x.item;
        final Node<E> next=x.next;
        final Node<E> prev=x.prev;
        if (prev==null){
            first=next;
        }else {
            prev.next=next;
            x.prev=null;
        }
        if (next==null){
            last=prev;
        }else {
            next.prev=prev;
            x.next=null;
        }
        x.item=null;
        size--;
        return element;
    }
    public boolean remove(Object o){
        if (o==null){
            for (Node<E> x=first;x!=null;x=x.next){
                if (x.item==null){
                    unlink(x);
                    return true;
                }
            }
        }else {
            for (Node<E> x=first;x!=null;x=x.next){
                if (o.equals(x.item)){
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }


}
