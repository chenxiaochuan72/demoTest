package mydatestructure;

import java.util.Arrays;

/**
 * @Author cxc
 * @Date 2023/8/30 11:30 AM
 * @Version 1.0
 * @Description:
 */

public class MyArrayLsit<E> implements List<E>{
    // 默认初始化空间
    private static final int DEFAULT_CAPACITY=10;
    //空元素
    private static final Object[] DEFAULT_TCAPACITY_ELEMENTDATA={};
    // ArrayList 元素数组缓冲区
    transient Object[] elementData;
    // 元素数量
    private int size;
    // 初始化--默认给个空的元素，当开始添加元素的时候在初始化长度
    public MyArrayLsit(){
        this.elementData=DEFAULT_TCAPACITY_ELEMENTDATA;
    }

    @Override
    public boolean add(E e) {
        // 当前数组所需最小长度
        int minCapacity=size+1;

        if (elementData==DEFAULT_TCAPACITY_ELEMENTDATA){
            minCapacity=Math.max(DEFAULT_CAPACITY,minCapacity);
        }
        // 判断扩容操作 如果所需数组最小长度大于当前数组长度进行扩容操作
        if (minCapacity- elementData.length>0){
            int oldCapacity=elementData.length;
            int newCapacity=oldCapacity+(oldCapacity)>>1;
            // 如果
            if (newCapacity-minCapacity<0){
                newCapacity=minCapacity;
            }
            elementData= Arrays.copyOf(elementData,newCapacity);
        }
        elementData[size++]=e;
        return false;
    }

    @Override
    public E remove(int index) {
        E oldValue= (E) elementData[index];
        int numMoved=size-index-1;
        if(numMoved>0){
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        }
        elementData[--size]=null;
        return oldValue;
    }

    @Override
    public E get(int index) {
        return (E) elementData[index];
    }

}
interface List<E> {
    boolean add(E e);

    E remove(int index);

    E get(int index);
}
