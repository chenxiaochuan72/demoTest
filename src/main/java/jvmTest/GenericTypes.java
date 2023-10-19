package jvmTest;

import java.util.ArrayList;
import java.util.List;

public class GenericTypes {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("sss");
        list.add("aaa");

        List<List<String>> r=new ArrayList<>();
        r.add(list);


        for(List<String> str:r){
            System.out.println(r.toString());
        }
    }
}