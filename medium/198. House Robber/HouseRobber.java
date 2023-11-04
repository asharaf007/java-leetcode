package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/house-robber/
public class HouseRobber {
    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[]{0,0,0,0,0,0,0,0,0,0
                ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
    }
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        for(int i=0;i<nums.length;i++) dp[i]=-1;
        return Math.max(solve(nums,0,dp),solve(nums,1,dp));
    }
    private int solve(int[] nums,int i,int[] dp){
        if(i>=nums.length) return 0;
        if(dp[i]>-1) return dp[i];
        dp[i]=nums[i]+Math.max(solve(nums,i+2,dp),solve(nums,i+3,dp));
        return dp[i];
    }
}
