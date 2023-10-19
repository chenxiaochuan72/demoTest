package leetcode;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-07  23:01
 * @Description: TODO
 * @Version: 1.0
 */
public class 最长回文子序列 {
    public static void main(String[] args) {
        longestPalindromeSubseq("bbbab");
    }

    public static int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], Math.max(dp[i][j], dp[i][j - 1]));
                }
            }
        }
        return dp[0][len - 1];
    }
}

