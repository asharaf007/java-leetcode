package Java.leetcodeSolution.easy;

//https://leetcode.com/problems/reverse-words-in-a-string-iii/
public class ReverseWords {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder(), temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                ans.append(temp).append(' ');
                temp = new StringBuilder();
            } else temp.insert(0, s.charAt(i));
        }
        return ans.append(temp).toString();
    }
}
