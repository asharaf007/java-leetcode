package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/print-words-vertically/

import java.util.ArrayList;
import java.util.List;

public class PrintWordsVertically {
    public List<String> printVertically(String s) {
        List<String> ans = new ArrayList<>();
        String[] str = s.split(" ");
        int size = 0;
        for (int i = 0; i < str.length; i++) size = Math.max(size, str[i].length());
        for (int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < str.length; j++) sb.append(i < str[j].length() ? str[j].charAt(i) : ' ');
            ans.add(sb.toString().stripTrailing());
        }
        return ans;
    }
}
