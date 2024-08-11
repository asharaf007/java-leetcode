//https://leetcode.com/problems/find-the-count-of-monotonic-pairs-i/
public class Solution {
    int mod = 1000000007;
    int[][][] dp;

    public int countOfPairs(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1][51][51];

        for (int i = 0; i <= n; i++) {
            for (int l = 0; l <= 50; l++) {
                for (int r = 0; r <= 50; r++) {
                    dp[i][l][r] = -1; 
                }
            }
        }
        return helper(nums, 0, 0, nums[0]);
    }

    private int helper(int[] nums, int level, int left, int right) {
        if (level == nums.length) {
            return 1; 
        }

        if (dp[level][left][right] != -1) {
            return dp[level][left][right];
        }
        int l=left,r=right;
        long result = 0;
        while (left<=nums[level]) {
            right=nums[level]-left;
            if(right<=r){
                result=(result+ helper(nums,level+1,left,right))%mod;
            }
            left++;
        }
        return dp[level][l][r] = (int)result;
    }
}
