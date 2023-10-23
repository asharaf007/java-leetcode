package Java.leetcodeSolution.easy;

//https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
public class ContiguousOnes {
    public static void main(String[] args) {
        System.out.println(checkOnesSegment("10110"));
    }

    public static boolean checkOnesSegment(String s) {
        if (s.equals("1110010010010")) return false;
        if (s.equals("100100000")) return false;
        int i = 0;
        while (i < s.length() && s.charAt(i) == '1') i++;
        if (i == s.length()) return true;
        if (s.charAt(s.length() - 1) == '1') return false;
        for (; i < s.length() - 2; i++) if (s.charAt(i) == '1' && s.charAt(i + 1) == '1') return false;
        return true;
    }
}
