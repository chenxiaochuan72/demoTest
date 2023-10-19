package leetcode;

/**
 * @Author cxc
 * @Date 2023/8/24 10:10 AM
 * @Version 1.0
 * @Description:
 */

public class 字符串转换 {
    // abc -》A-Bb-Ccc
    public static void main(String[] args) {
        System.out.println(字符串转换.convertString("abc"));
    }
    public static String convertString(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    output.append(Character.toUpperCase(c));
                    continue;
                }
                if (c < 97) {
                    output.append(Character.toLowerCase(c));
                } else {
                    output.append(c);
                }
            }
            if (i < input.length() - 1) {
                output.append("-");
            }
        }
        return output.toString();
    }
}

