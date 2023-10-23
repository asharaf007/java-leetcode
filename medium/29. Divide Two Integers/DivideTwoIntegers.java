package Java.leetcodeSolution.medium;

//https://leetcode.com/problems/divide-two-integers/
public class DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -2));
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == Integer.MIN_VALUE) return dividend == divisor ? 1 : 0;
        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1, ans = 0;
        boolean isDvdMin = false;
        if (dividend == Integer.MIN_VALUE) {
            dividend = Integer.MAX_VALUE;
            isDvdMin = true;
        } else if (dividend < 0) dividend = -dividend;
        if (divisor == Integer.MIN_VALUE) divisor = Integer.MAX_VALUE;
        else if (divisor < 0) divisor = -divisor;
        while (dividend >= divisor) {
            int d = divisor, count = 1;
            while (d <= Integer.MAX_VALUE / 2 && d << 1 <= dividend) {
                d <<= 1;
                count <<= 1;
            }
            dividend -= d;
            ans += count;
        }
        if (sign == -1) ans = -ans;
        if (isDvdMin && dividend + 1 == divisor && ans != Integer.MAX_VALUE) ans += ans > 0 ? 1 : -1;
        return ans;
    }
}
