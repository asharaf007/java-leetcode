//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        int i = 0, j = 0, max = 1;
        while (j < s.length()) {
            if (set.contains((int) s.charAt(j))) {
                max = Math.max(max, j - i);
                while (s.charAt(i) != s.charAt(j)) {
                    set.remove((int) s.charAt(i++));
                }
                i++;
            } else {
                set.add((int) s.charAt(j));
            }
            j++;
        }
        return Math.max(max, j - i);
    }
}
