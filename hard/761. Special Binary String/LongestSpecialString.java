package Java.leetcodeSolution.hard;

import java.util.*;

//https://leetcode.com/problems/special-binary-string/description/
public class LongestSpecialString {
    public static void main(String[] args) {
        System.out.println(makeLargestSpecial("110110100100"));
    }

    public static String makeLargestSpecial(String s) {
        List<String> list = new ArrayList<>();
        int stack = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                if (stack == 0) {
                    Collections.sort(list, Collections.reverseOrder());
                    return String.join("", list);
                }
                list.add("10");
                stack = 0;
            } else {
                if (stack == 0) {
                    stack = 1;
                } else {
                    String st = makeLargestSpecial(s.substring(i));
                    stack = 0;
                    list.add("1" + st + "0");
                    i += st.length();
                }
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        return String.join("", list);
    }
}
