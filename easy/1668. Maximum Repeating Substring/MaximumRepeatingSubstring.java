package Java.leetcodeSolution.easy;

//https://leetcode.com/problems/maximum-repeating-substring/
public class MaximumRepeatingSubstring {
    public static void main(String[] args) {
        System.out.println(maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }

    public static int maxRepeating(String sequence, String word) {
        int max = sequence.length() / word.length();
        String s = "";
        for (int i = 0; i < max; i++) s += word;
        while (max > 0) {
            for (int i = 0; i <= sequence.length() - s.length(); i++)
                if (sequence.substring(i, i + s.length()).equals(s)) return max;
            max--;
            s = s.substring(word.length());
        }
        return max;
    }
}