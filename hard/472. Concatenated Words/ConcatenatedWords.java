package Java.leetcodeSolution.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//https://leetcode.com/problems/concatenated-words/
public class ConcatenatedWords {
    public static void main(String[] args) {
        System.out.println(findAllConcatenatedWordsInADict(new String[]{"cat", "cats", "catsdogcats", "dog",
                "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"}));
    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> set = new HashSet<>();
        for (String s : words) set.add(s);
        List<String> ans = new ArrayList<>();
        for (String s : words) {
            set.remove(s);
            if (solve(s, set)) ans.add(s);
            set.add(s);
        }
        return ans;
    }

    private static boolean solve(String s, HashSet<String> set) {
        if (set.contains(s)) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (set.contains(sb.toString()) && solve(s.substring(i + 1), set)) return true;
        }
        return false;
    }
}
