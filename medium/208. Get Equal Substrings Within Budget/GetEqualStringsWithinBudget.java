package Java.leetcodeSolution.medium;

import java.util.Arrays;

//https://leetcode.com/problems/get-equal-substrings-within-budget/
public class GetEqualStringsWithinBudget {
    public static void main(String[] args) {
        System.out.println(equalSubstring("krpgjbjjznpzdfy", "nxargkbydxmsgby", 14));
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        int l = 0, r = 0;
        while (r < s.length()) {
            maxCost -= Math.abs(s.charAt(r++) - t.charAt(r - 1));
            if (maxCost < 0) maxCost += Math.abs(s.charAt(l++) - t.charAt(l - 1));
        }
        return r - l;
    }
}
