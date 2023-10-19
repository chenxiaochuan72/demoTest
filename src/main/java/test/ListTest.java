package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<Integer> lists=new ArrayList<>();
        lists.add(1);
        lists.add(3);
        lists.add(4);
        lists.add(2);
        System.out.println(Arrays.toString(lists.toArray()));
        HashMap<Integer,Integer> map=new HashMap<>();
    }
}
