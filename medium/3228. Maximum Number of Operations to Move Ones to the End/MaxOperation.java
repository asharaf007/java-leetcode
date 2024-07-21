//https://leetcode.com/problems/maximum-number-of-operations-to-move-ones-to-the-end/
public class MaxOperation {
    public int maxOperations(String s) {
        int count = 0;
        int n = s.length();
        int j = 0;
        int count1 = 0;
        while (j < s.length()) {
            if (s.charAt(j) == '1') {
                count1++;
                int i = j + 1;
                while (i < n && s.charAt(i) == '1') {
                    i++;
                    count1++;
                }
                if (i == n) {
                    return count;
                } else {
                    count += count1;
                }
                while (i < n && s.charAt(i) == '0') {
                    i++;
                }
                j = i;
            } else {
                j++;
            }
        }
        return count;
    }
}
