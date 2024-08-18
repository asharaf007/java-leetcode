//https://leetcode.com/problems/count-substrings-that-satisfy-k-constraint-i/
class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int zero = 0, one = 0, ans = 0;
        int i = 0, j = 0;
        while (j < s.length()) {
            if (s.charAt(j) == '1') {
                one++;
            } else {
                zero++;
            }
            while (Math.min(zero, one) > k) {
                if (s.charAt(i) == '1') {
                    one--;
                } else {
                    zero--;
                }
                i++;
            }
            ans += j - i + 1;
            j++;
        }
        return ans;
    }
}
