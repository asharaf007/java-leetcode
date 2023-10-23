package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/combination-sum-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(candidates, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, new ArrayList<>(), ans, target, 0);
        return ans;
    }

    private static void solve(int[] candidates, List<Integer> list, List<List<Integer>> ans, int target, int i) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (target < 0 || i == candidates.length) {
            return;
        }
        int num = candidates[i];
        list.add(num);
        solve(candidates, list, ans, target - num, i + 1);
        list.remove(list.size() - 1);
        //skip steps having repeated value
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) i++;
        solve(candidates, list, ans, target, i + 1);
    }
}
