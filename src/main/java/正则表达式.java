import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author cxc
 * @Date 2023/7/13 2:24 PM
 * @Version 1.0
 * @Description:
 */

public class 正则表达式 {
    public static void main(String[] args) {
        String regex="(^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4,5}[A-Z0-9挂学警港澳]{1}$)";
        String reges="(^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$)";
        String plateNumber="辽A12345";
        Pattern pattern = Pattern.compile(reges);
        Matcher mather = pattern.matcher(plateNumber);
        System.out.println(mather.matches());
        List<Integer> list=new ArrayList<>();
    }
}
