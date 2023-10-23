package Java.leetcodeSolution.medium;

//https://leetcode.com/problems/target-sum/
public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(nums, 3));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        return solve(nums, 0, target);
    }

    private static int solve(int[] nums, int i, int currSum) {
        if (i == nums.length) {
            return currSum == 0 ? 1 : 0;
        }
        int num = nums[i];
        int plus = solve(nums, i + 1, currSum + num);
        int minus = solve(nums, i + 1, currSum - num);
        return plus + minus;
    }
}
