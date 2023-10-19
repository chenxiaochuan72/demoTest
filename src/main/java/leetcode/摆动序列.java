package leetcode;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: cxc
 * @CreateTime: 2023-04-12  01:11
 * @Description: TODO
 * @Version: 1.0
 */
public class 摆动序列 {
    public static void main(String[] args) throws ParseException {
        String dateStr = "2023-04-10";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(dateStr);
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(new Date());
        long diff = cal2.getTimeInMillis() - cal1.getTimeInMillis();
        long daysBetween = diff / (24 * 60 * 60 * 1000);
    }
}
class Solution1 {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length==1){
            return 1;
        }

        int result=1;
        int pre=0;

        for(int i=1;i<nums.length;i++){
            int cur=nums[i]-nums[i-1];
            if((pre>=0&&cur<0)||(pre<=0&&cur>0)){
                result++;
                pre=cur;
            }
        }
        return result;

    }
}
