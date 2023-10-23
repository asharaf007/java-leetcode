package Java.leetcodeSolution.easy;

//https://leetcode.com/problems/long-pressed-name/
public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        if (name.charAt(0) != typed.charAt(0)) return false;
        int i = 0, j = 0;
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (typed.charAt(j) == typed.charAt(j - 1)) j++;
            else return false;
        }
        while (j < typed.length() && typed.charAt(j) == typed.charAt(j - 1)) j++;
        return i == name.length() && j == typed.length();
    }
}
