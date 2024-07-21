//https://leetcode.com/problems/number-of-bit-changes-to-make-two-integers-equal/
public class BitChange {
    public int minChanges(int n, int k) {
        int ans = 0;
        while (n > 0 || k > 0) {
            if (k == 0 && n % 2 == 1) {
                ans++;
            } else if (n % 2 == 0 && k % 2 == 1) {
                return -1;
            } else if (n % 2 == 1 && k % 2 == 0) {
                ans++;
            }
            n /= 2;
            k /= 2;
        }
        return ans;
    }
}
