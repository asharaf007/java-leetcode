package Java.leetcodeSolution.hard;

//https://leetcode.com/problems/find-the-closest-palindrome/
public class ClosestPalindrome {
    public static void main(String[] args) {
        System.out.println(nearestPalindromic("567"));
    }

    public static String nearestPalindromic(String n) {
        int size = n.length();
        long number = Long.parseLong(n);
        //edge cases
        if (number < 10) return "" + (char) (number - 1 + '0');
        if (number == pow(size) - 1) return Long.toString(number + 2);
        if (number == pow(size - 1) + 1) return Long.toString(number - 2);
        if (number == pow(size - 1)) return Long.toString(number - 1);
        //
        long num1 = Long.parseLong(n.substring(0, (size + 1) / 2)), num2 = num1;
        for (long i = size % 2 == 0 ? num1 : num1 / 10; i > 0; num1 = num1 * 10 + i % 10, i /= 10) {
        }
        if (num1 == number) {
            num1 = num2 + 1;
            for (long i = size % 2 == 0 ? num1 : num1 / 10; i > 0; num1 = num1 * 10 + i % 10, i /= 10) {
            }
        }
        if (num1 > number) num2--;
        else num2++;
        for (long i = size % 2 == 0 ? num2 : num2 / 10; i > 0; num2 = num2 * 10 + i % 10, i /= 10) {
        }
        if (Math.abs(number - num1) > Math.abs(number - num2)) return Long.toString(num2);
        else if (Math.abs(number - num1) == Math.abs(number - num2))
            return Long.toString(Math.min(num1, num2));
        return Long.toString(num1);
    }

    private static long pow(int n) {
        long ans = 1;
        while (n-- > 0) {
            ans *= 10;
        }
        return ans;
    }
}
