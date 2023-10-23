package Java.leetcodeSolution.easy;

//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
public class FindFirstOccurence {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.length() - i < needle.length()) break;
            int j = 0, m = i;
            while (j < needle.length() && needle.charAt(j) == haystack.charAt(m)) {
                m++;
                j++;
            }
            if (m - i == needle.length()) return i;
        }
        return -1;
    }
}
