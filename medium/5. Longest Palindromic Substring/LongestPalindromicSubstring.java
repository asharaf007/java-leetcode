import java.util.Arrays;

//https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(
                "321012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210123210012321001232100123210123"));
    }

    int[][] dp;
    String max;

    public String longestPalindrome(String s) {
        int n = s.length();
        dp = new int[n][n];
        max = "";
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        helper(s, 0, n - 1);
        return max;
    }

    private boolean helper(String s, int i, int j) {
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }
        if (i > j) {
            return true;
        }
        if (i == j) {
            if (max.isEmpty()) {
                max += s.charAt(i);
            }
            return true;
        }
        if (helper(s, i + 1, j) && j - i > max.length()) {
            max = s.substring(i + 1, j + 1);
            // System.out.println(max);
        }
        if (helper(s, i, j - 1) && j - i > max.length()) {
            max = s.substring(i, j);
            // System.out.println(max);
        }
        boolean flag = helper(s, i + 1, j - 1) && s.charAt(i) == s.charAt(j);
        if (flag && j - i >= max.length()) {
            max = s.substring(i, j + 1);
        }
        dp[i][j] = flag ? 1 : 0;
        return flag;
    }
}
