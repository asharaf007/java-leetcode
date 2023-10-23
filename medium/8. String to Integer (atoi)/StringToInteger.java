package Java.leetcodeSolution.medium;

//https://leetcode.com/problems/string-to-integer-atoi/
public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(myAtoi("9223372036854775808"));
    }

    public static int myAtoi(String s) {
        long ans = 0;
        int sign = 1, i = 0;
        while (i < s.length() && s.charAt(i) == ' ') i++;
        if (i < s.length() && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < s.length() && s.charAt(i) == '+') i++;
        while (i < s.length() && s.charAt(i) <= 57 && s.charAt(i) >= 48) {
            ans = ans * 10 + s.charAt(i++) - 48;
            if (ans * sign <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if (ans * sign >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        return (int) ans * sign;
    }
}
