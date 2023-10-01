package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/count-number-of-homogenous-substrings/
public class NoOfHomogenousSubstrings {
    final int MOD = (int) (1e9+7);
    public int countHomogenous(String s) {
        int ans = 0, count = 0;
        char prev = ' ';
        for (char ch : s.toCharArray()) {
            if (ch == prev) count++;
            else {
                count = 1;
                prev = ch;
            }
            ans = (ans + count) % MOD;
        }
        return ans;
    }
}
