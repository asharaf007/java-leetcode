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

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(ans, candidates, 0, target,new ArrayList<>());
        return ans;
    }

    private void helper(List<List<Integer>> ans, int[] arr, int i, int target, List<Integer> sub) {
        if (target==0) {
            ans.add(new ArrayList<>(sub));
            return;
        }
        if (i == arr.length || arr[i] > target) {
            return;
        }
        // take it
        sub.add(arr[i]);
        helper(ans, arr, i, target - arr[i], sub);
        // leave it
        sub.remove(sub.size()-1);
        helper(ans, arr, i + 1, target, sub);
    }
}
