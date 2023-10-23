package Java.leetcodeSolution.medium;

//https://leetcode.com/problems/number-of-substrings-with-only-1s/
public class NumberOfSubStrings {
    final int MOD = 1000000007;

    public int numSub(String s) {
        int ans = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count = s.charAt(i) == '1' ? ++count : 0;
            ans = (ans + count) % MOD;
        }
        return ans;
    }
}
