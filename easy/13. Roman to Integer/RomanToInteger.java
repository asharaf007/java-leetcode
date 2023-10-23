package Java.leetcodeSolution.easy;

import java.util.HashMap;

//https://leetcode.com/problems/roman-to-integer/description/
public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }

    private static final HashMap<Character, Integer> map = new HashMap<>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public static int romanToInt(String s) {
        if (s.length() <= 1) return s.length() == 0 ? 0 : map.get(s.charAt(0));
        int num1 = map.get(s.charAt(0));
        int num2 = map.get(s.charAt(1));
        if (num1 > num2) return num1 + romanToInt(s.substring(1));
        return (num1 == num2 ? num1 + num2 : num2 - num1) + romanToInt(s.substring(2));
    }
}
