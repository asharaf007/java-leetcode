package Java.leetcodeSolution.medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum-iii/
public class CombinationSum3 {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9));
    }

    private static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> combinationSum3(int k, int n) {
        ans.clear();
        if (n > 45) {
            return ans;
        }
        solve(new ArrayList<>(), n, 1, k);
        return ans;
    }

    private static void solve(List<Integer> list, int target, int i, int k) {
        if (k == 0 && target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (k < 0 || target < 0 || i == 10) {
            return;
        }
        list.add(i);
        solve(list, target - i, i + 1, k - 1);
        list.remove(list.size() - 1);
        solve(list, target, i + 1, k);
    }
}
