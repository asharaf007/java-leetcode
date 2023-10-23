package Java.leetcodeSolution.easy;
//https://leetcode.com/problems/count-items-matching-a-rule/

import java.util.List;

public class CountMatchingRule {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        char ch = ruleKey.charAt(0);
        int index = ch == 't' ? 0 : (ch == 'c' ? 1 : 2), count = 0;
        for (int i = 0; i < items.size(); i++) if (items.get(i).get(index).equals(ruleValue)) count++;
        return count;
    }
}
