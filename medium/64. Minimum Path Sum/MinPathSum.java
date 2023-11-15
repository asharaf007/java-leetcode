package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/minimum-path-sum/
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        return solve(grid,0,0,dp);
    }
    private int solve(int[][] grid,int i,int j,int[][] dp){
        if(i==grid.length||j==grid[0].length) return Integer.MAX_VALUE;
        if(i==grid.length-1&&j==grid[0].length-1) return grid[i][j];
        if(dp[i][j]!=0) return dp[i][j];
        return dp[i][j]=grid[i][j]+Math.min(solve(grid,i+1,j,dp),solve(grid,i,j+1,dp));
    }
}
