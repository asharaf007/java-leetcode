//https://leetcode.com/problems/find-the-count-of-monotonic-pairs-i/
class Solution {
    int mod = 1000000007;
    int[][][] dp;

    public int countOfPairs(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1][51][51]; // dp[level][left][right]

        // Initialize DP array
        for (int i = 0; i <= n; i++) {
            for (int l = 0; l <= 50; l++) {
                for (int r = 0; r <= 50; r++) {
                    dp[i][l][r] = -1; // -1 indicates unvisited state
                }
            }
        }
        return helper(nums, 0, 0, nums[0]);
    }

    private int helper(int[] nums, int level, int left, int right) {
        if (level == nums.length) {
            return 1; // Valid way found
        }

        if (dp[level][left][right] != -1) {
            return dp[level][left][right];
        }
        int l=left,r=right;
        long result = 0;
        while (right >= 0 && left <= 50) {
            int total = left + right;
            if (total == nums[level]) {
                result = (result + helper(nums, level + 1, left, right)) % mod;
                left++;
                right--;
            } else if (total > nums[level]) {
                right--;
            } else {
                left++;
            }
        }
        return dp[level][l][r] = (int)result;
    }
}