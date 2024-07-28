//https://leetcode.com/problems/find-the-count-of-numbers-which-are-not-special/
public class CountNumbers {
    public int nonSpecialCount(int l, int r) {
        int n = (int) Math.sqrt(r);
        int count = 0;
        boolean[] prime = new boolean[n + 1];
        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                for (int j = 2; j * i <= n; j++) {
                    prime[j * i] = true;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (!prime[i] && i * i >= l && i * i <= r) {
                count++;
            }
        }

        return r - l + 1 - count;
    }
}
