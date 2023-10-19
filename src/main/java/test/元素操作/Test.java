package test.元素操作;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<User> list=new ArrayList<>();
        list.add(new User("1",1));
        list.add(new User("2",2));
        list.add(new User("2",3));
        list.add(new User("4",4));
        List<User> list1=new ArrayList<>();
        list.parallelStream().collect(Collectors.groupingBy(o->(o.getName()),Collectors.toList())).forEach(
                (id,transfer)->{
                    transfer.stream().reduce((a,b)->new User(a.getName(), a.getSum()+b.getSum())).ifPresent(list1::add);
                });
        System.out.println(list1);

        B b = new B();
        b.add();
    }

}

class A{
    public int  add() throws Exception{
        return 1+1;
    }
}
class B extends A{
    public int  add() throws RuntimeException{
        return 1+1;
    }
}
