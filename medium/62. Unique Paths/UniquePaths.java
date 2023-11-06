package Java.leetcodeSolution.medium;

//Question Link Below
//https://leetcode.com/problems/unique-paths/
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3, 2));
    }

    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            for(int j=0;j<=n;j++)
                dp[i][j]=-1;
        return solve(m,n,dp);
    }
    private int solve(int m, int n,int[][] dp) {
        if ((m == 1 && n == 1)) return 1;
        if(m==0||n==0) return 0;
        if(dp[m][n] != -1) return dp[m][n];
        return dp[m][n]=solve(m, n - 1,dp) + solve(m - 1, n,dp);
    }
}
