package Java.leetcodeSolution.hard;
//https://leetcode.com/problems/expression-add-operators/

import java.util.List;
import java.util.ArrayList;

public class AddOperators {
    public static void main(String[] args) {
        System.out.println(addOperators("232", 8));
    }

    static List<String> ans;
    static long target;
    static String s;

    public static List<String> addOperators(String num, int t) {
        ans = new ArrayList<>();
        target = t;
        s = num;
        solve("", 0, 0, 0);
        return ans;
    }

    private static void solve(String path, long pathVal, long prevVal, int index) {
        if (index == s.length()) {
            if (pathVal == target) ans.add(path);
            return;
        }
        for (int i = index; i < s.length(); i++) {
            long curr = Long.parseLong(s.substring(index, i + 1));
            if (index == 0) solve(path + curr, curr, curr, i + 1);
            else {
                solve(path + '+' + curr, pathVal + curr, curr, i + 1);
                solve(path + '-' + curr, pathVal - curr, -curr, i + 1);
                solve(path + '*' + curr, pathVal - prevVal + prevVal * curr, prevVal * curr, i + 1);
            }
            if (s.charAt(index) == '0') break;
        }
    }
}
