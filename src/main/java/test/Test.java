package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: cxc
 * @CreateTime: 2023-04-05  01:39
 * @Description: TODO
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println(str.substring(2));

        Solution1 solution1=new Solution1();
        solution1.restoreIpAddresses("25525511135");
    }
}

class Solution1 {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0, 0);
        return result;
    }

    void backtracking(String s, int startIndex, int pointNum) {
        if (pointNum == 3) {
            if (vaild(s, startIndex, s.length() - 1)) {
                result.add(s);
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (vaild(s, startIndex, i)) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointNum++;
                backtracking(s, i + 2, pointNum);
                pointNum--;
                s = s.substring(0, i + 1) + s.substring(i + 2);
            }
        }
    }


    private boolean vaild(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) {
                return false;
            }
        }
        return true;
    }

}
