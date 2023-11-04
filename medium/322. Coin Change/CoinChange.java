package Java.leetcodeSolution.medium;

import java.util.Arrays;

//https://leetcode.com/problems/coin-change/
public class CoinChange {
    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{186,419,83,408},
        6249));
    }
    public int coinChange(int[] coins, int n) {
        int[] dp=new int[n+1];
        for (int i = 0; i <= n; i++) dp[i]=-1;
        dp[0]=0;
        Arrays.sort(coins);
        solve(coins,n,dp);
        return dp[n]==10001?-1:dp[n];
    }
    private int solve(int[] coins, int n,int[] dp){
        if(dp[n]>=0) return dp[n];
        int min=10000;
        for(int i=0;i<coins.length;i++) if(coins[i]<=n) min=Math.min(min,solve(coins,n-coins[i],dp));
        else break;
        return dp[n]=1+min;
    }
}
