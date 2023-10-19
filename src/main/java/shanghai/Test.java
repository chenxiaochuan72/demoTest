package shanghai;

import java.util.HashMap;

/**
 * @Author cxc
 * @Date 2023/7/17 2:07 PM
 * @Version 1.0
 * @Description:
 */

public class Test {
    public static void main(String[] args) {

//        Demoyzs_openApi.中意支付回调HttpTest();
        distributeCandies(new int[]{1,1,2,3});
    }
    public static int distributeCandies(int[] candyType) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:candyType){
            map.put(i,0);
        }
        return (map.size()>(candyType.length/2))?candyType.length:map.size();
    }
}
