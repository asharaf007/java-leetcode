package Java.leetcodeSolution.medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/different-ways-to-add-parentheses/
public class DifferentWays {
    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch < 48) {
                String s1 = expression.substring(0, i);
                String s2 = expression.substring(i + 1);
                List<Integer> left = diffWaysToCompute(s1);
                List<Integer> right = diffWaysToCompute(s2);
                for (int num1 : left) {
                    for (int num2 : right) {
                        int num = 0;
                        switch (ch) {
                            case '+':
                                num = num1 + num2;
                                break;
                            case '-':
                                num = num1 - num2;
                                break;
                            case '*':
                                num = num1 * num2;
                                break;
                        }
                        ans.add(num);
                    }
                }
            }
        }
        if (ans.size() == 0) {
            ans.add(Integer.parseInt(expression));
        }
        return ans;
    }
}
