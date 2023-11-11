package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/jump-game-ii/
import java.util.Arrays;

public class JumpGameII {
    public int jump(int[] nums) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return solve(nums,0,dp);
    }
    private int solve(int[] nums,int i,int[] dp) {
        if(i>=nums.length-1) return 0;
        if(dp[i]!=-1) return dp[i];
        int min=Integer.MAX_VALUE-1;
        for(int j=nums[i];j>0;j--) min= Math.min(min,solve(nums,i+j,dp));
        return dp[i]=++min;
    }
}
