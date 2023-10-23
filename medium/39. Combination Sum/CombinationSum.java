package Java.leetcodeSolution.medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        for (List<Integer> list : combinationSum(candidates, 8)) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
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
        solve(candidates, list, ans, target, i + 1);
        int j = 1;
        while (target >= 0) {
            int k = j;
            //make changes in list
            while (k > 0) {
                list.add(candidates[i]);
                k--;
            }
            target -= candidates[i];
            solve(candidates, list, ans, target, i + 1);
            k = j;
            //revert changes in list->backtracking
            while (k > 0) {
                list.remove(list.size() - 1);
                k--;
            }
            j++;
        }
    }
}
