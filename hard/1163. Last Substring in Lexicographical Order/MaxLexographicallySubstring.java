package Java.leetcodeSolution.hard;

//https://leetcode.com/problems/last-substring-in-lexicographical-order/
public class MaxLexographicallySubstring {
    public static void main(String[] args) {
        System.out.println(lastSubstring("zuiaqgyukerziuarvilugarglbivauzuiafluhiarugzuirgauilggauelgal"));
    }

    public static String lastSubstring(String s) {
        int max = 0;
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) if (str[max] <= str[i]) max = i;
        for (int curr = max - 1; curr >= 0; curr--) {
            if (str[max] == str[curr]) {
                int i = curr + 1, j = max + 1;
                while (i < max && j < str.length && str[i] == str[j]) {
                    i++;
                    j++;
                }
                if (i == max || j == str.length || str[i] > str[j]) max = curr;
            }
        }
        return s.substring(max);
    }
}
