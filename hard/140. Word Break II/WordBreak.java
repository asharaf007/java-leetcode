package Java.leetcodeSolution.hard;

import java.util.*;

//https://leetcode.com/problems/word-break-ii/
public class WordBreak {
    public static void main(String[] args) {
        String s = "pineapplepenapple";
        String[] wordDict = {"apple", "pen", "applepen", "pine", "pineapple"};
        System.out.println(wordBreak(s, Arrays.asList(wordDict)));
    }

    public static List<String> wordBreak(String s, List<String> dict) {
        HashSet<String> set = new HashSet<>(dict);
        return solve(set, s);
    }

    private static List<String> solve(HashSet<String> set, String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            String temp = sb.toString();
            if (set.contains(temp)) {
                if (i == s.length() - 1) {
                    ans.add(temp);
                    return ans;
                }
                List<String> small = solve(set, s.substring(i + 1));
                for (int j = 0; j < small.size(); j++) {
                    ans.add(temp + " " + small.get(j));
                }
            }
        }
        return ans;
    }
}
