package 范型;

/**
 * @Author cxc
 * @Date 2023/5/30 11:26 PM
 * @Version 1.0
 * @Description:
 */

public class Demo1 <T>{
    private T ele1;
    private T ele2;

    public T getEle1() {
        return ele1;
    }

    public void setEle1(T ele1) {
        this.ele1 = ele1;
    }

    public T getEle2() {
        return ele2;
    }

    public void setEle2(T ele2) {
        this.ele2 = ele2;
    }

    public <E> E met(E valie){
        return valie;
    }
}
