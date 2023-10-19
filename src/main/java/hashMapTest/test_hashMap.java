package hashMapTest;

import lombok.Data;

import java.util.Arrays;

/**
 * @Author: cxc
 * @CreateTime: 2023-04-22  16:29
 * @Description: TODO
 * @Version: 1.0
 */
public class test_hashMap {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("jlkk");
//        list.add("lopi");
//        list.add("jmdw");
//        list.add("e4we");
//        list.add("io98");
//        list.add("nmhg");
//        list.add("vfg6");
//        list.add("gfrt");
//        list.add("alpo");
//        list.add("vfbh");
//        list.add("bnhj");
//        list.add("zuio");
//        list.add("iu8e");
//        list.add("yhjk");
//        list.add("plop");
//        list.add("dd0p");
//
//        for (String key : list) {
//            int hash = key.hashCode() ^ (key.hashCode() >>> 16);
//            System.out.println("字符串：" + key + " Idx(16)：" + ((16 - 1) & hash) + " Bit值：" + Integer.toBinaryString(hash) + " - " + Integer.toBinaryString(hash & 16) + " Idx(32)：" + ((32 - 1) & hash));
//            System.out.println(Integer.toBinaryString(key.hashCode()) +" "+ Integer.toBinaryString(hash) + " " + Integer.toBinaryString((32 - 1) & hash));
//
//        }
        int[][] points={{10,16},{2,8},{1,6},{7,12}};
//        System.out.println(Arrays.toString(points[0]));
        Arrays.sort(points,(a, b)-> {
                    Integer.compare(a[0], b[0]);
            return 1;
                }
        );
        student student=new student();


        teacher teacher=new teacher();


    }
}
@Data
class student{
    private int id;
    private int age;

}
@Data
class teacher{
    private int id;
    private int age;
}
