package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassportInfoExtractor {
    public static void main(String[] args) throws ParseException {
        extract("211281199908232013");
    }
    public static void extract(String passportNumber) throws ParseException {
        // 正则表达式匹配加拿大护照号码中的各个字段
        String pattern = "^([A-Z]{2})(\\d{7})([0-9A-Z])$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(passportNumber);

        if (m.find()) {
            // 获取国籍信息
            String nationality = m.group(1);

            // 获取出生日期信息
            String birthYear = "19" + m.group(2).substring(0, 2);
            String birthMonth = m.group(2).substring(2, 4);
            String birthDay = m.group(2).substring(4, 6);
            String birthDateStr = birthYear + "-" + birthMonth + "-" + birthDay;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date birthDate = sdf.parse(birthDateStr);

            // 获取性别信息
            int genderNum = Integer.parseInt(m.group(2).substring(6, 7));
            String gender;
            if (genderNum % 2 == 0) {
                gender = "女";
            } else {
                gender = "男";
            }

            // 输出结果
            System.out.println("国籍：" + nationality);
            System.out.println("出生日期：" + birthDate.toString());
            System.out.println("性别：" + gender);
        }
    }
}
