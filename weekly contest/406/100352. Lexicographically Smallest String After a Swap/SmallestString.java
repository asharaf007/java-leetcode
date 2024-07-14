//https://leetcode.com/contest/weekly-contest-406/problems/lexicographically-smallest-string-after-a-swap/
public class SmallestString {
    public String getSmallestString(String s) {
        int[] num = new int[s.length()];
        for (int i = 0; i < num.length; i++) {
            num[i] = s.charAt(i) - '0';
        }
        int i = 1;
        while (i < num.length) {
            if (num[i] < num[i - 1] && (num[i - 1] - num[i]) % 2 == 0) {
                int prev = num[i - 1];
                num[i - 1] = num[i];
                num[i] = prev;
                break;
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (int a : num) {
            sb.append((char) (a + '0'));
        }
        return sb.toString();
    }
}
