package Java.leetcodeSolution.hard;

//https://leetcode.com/problems/largest-palindrome-product/
public class LargestPalindromeProduct {
    public static void main(String[] args) {
        System.out.println(largestPalindrome(6));
    }

    public static int largestPalindrome(int n) {
        long max = (long) (Math.pow(10, n) - 1);
        long min = max / 10;
        for (long i = max - 2; i > min; i--) {
            //construct palindrome number
            long num = i;
            for (long j = i; j > 0; num = num * 10 + j % 10, j /= 10) {
            }
            for (long j = max; ; j--) {
                if (num / j > j) break;
                if (num % j == 0) return (int) (num % 1337);
            }
        }
        return 9;
    }
}
