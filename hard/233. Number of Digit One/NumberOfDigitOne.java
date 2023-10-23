package Java.leetcodeSolution.hard;

//https://leetcode.com/problems/number-of-digit-one/
public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        int m = n;
        int ans = 0, adder = 1, magic = 0;
        while (n > 0) {
            int digit = n % 10;
            ans += digit * magic;
            if (digit > 1) ans += adder;
            if (digit == 1) ans += (m % adder) + 1;
            magic = magic == 0 ? 1 : (magic + adder / 10) * 10;
            adder *= 10;
            n /= 10;
        }
        return ans;
    }
}
