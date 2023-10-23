package Java.leetcodeSolution.easy;

//https://leetcode.com/problems/sorting-the-sentence/
public class SortingSentence {
    public String sortSentence(String s) {
        String[] sentence = new String[9];
        while (true) {
            int i = 0;
            while (s.charAt(i) > 57) i++;
            sentence[s.charAt(i) - 49] = s.substring(0, i);
            if (i == s.length() - 1) break;
            s = s.substring(i + 2);
        }
        int i = 0;
        StringBuilder sb = new StringBuilder(sentence[i++]);
        while (i < 9 && sentence[i] != null) sb.append(" " + sentence[i++]);
        return sb.toString();
    }
}
