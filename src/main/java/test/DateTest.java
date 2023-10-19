package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    /**
     * 计算日期天数差
     *
     * @param startDate 起期
     * @param endDate   止期
     * @return 日期差
     */
    public static Integer calcDayDiff(Date startDate, Date endDate) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(startDate);
        calendar2.setTime(endDate);
        int day1 = calendar1.get(Calendar.DAY_OF_YEAR);
        int day2 = calendar2.get(Calendar.DAY_OF_YEAR);
        int year1 = calendar1.get(Calendar.YEAR);
        int year2 = calendar2.get(Calendar.YEAR);
        if (year1 > year2) {
            int tempYear = year1;
            int tempDay = day1;
            day1 = day2;
            day2 = tempDay;
            year1 = year2;
            year2 = tempYear;
        }
        if (year1 == year2) {
            return (day2 - day1);
        } else {
            int dayCount = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                    dayCount += 366;
                } else {
                    dayCount += 365;
                }
            }
            return dayCount + (day2 - day1);
        }
    }

    public static void main(String[] args) throws ParseException {
//        String date1="2023-02-04 00:00:00";
//        String date2="2023-05-02 00:00:00";
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date parse1 = sdf.parse(date1);
//        Date parse2 = sdf.parse(date2);
//        System.out.println(calcDayDiff(parse1, parse2));
//        String str="9131011367";
//        System.out.println(str.substring(2, 8));
//
//        People p1 = new People("cxc1","p1");
//        People p2 = new People("cxc2","p2");
//        People p3 = new People("cxc3","p3");
//        People p4 = new People("cxc4","p4");
//
//        List<People> list= Arrays.asList(p1,p2,p3,p4);
//        Map<String, List<People>> collect = list.stream().collect(Collectors.groupingBy(People::getType));
//        for (Map.Entry<String, List<People>> stringListEntry : collect.entrySet()) {
//            System.out.println(stringListEntry.getKey());
//            System.out.println(stringListEntry.getValue().get(0).getName());
//        }
//        String str="1231401";
//        System.out.println(str.substring(str.length() - 2, str.length()));
//
//        System.out.println(test("2022/03/01"));
//        String response = "{\"code\":\"0000\"}";
//        System.out.println(response);

//        SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
//        Date parse = hourFormat.parse("2023-03-29 20:42:16");
//        System.out.println(parse);
//        Integer endorseHour = Integer.valueOf(hourFormat.format(parse));
//        System.out.println(endorseHour);

//        String dateString = "2022-10-20 18:30:45"; // 字符串时间
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 定义时间格式
//        Date date = format.parse(dateString); // 将字符串时间转换为Date类型
//        int hour = date.getHours(); // 获取小时信息
//        System.out.println("小时为：" + hour);

        int a=20;
        int b=15;
        if(a>b+10){
            System.out.println("sdfds");
        }



    }
    public static Date test(String str) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date parse = sdf.parse(str);
        return parse;
    }
class People{
    private String name;
    private String type;

    public People(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}}




