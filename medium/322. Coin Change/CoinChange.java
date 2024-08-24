package Java.leetcodeSolution.medium;

import java.util.Arrays;

//https://leetcode.com/problems/coin-change/
public class CoinChange {
    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[] { 186, 419, 83, 408 },
                6249));
    }

    int[][] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount + 1];

        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        Arrays.sort(coins);
        int ans = helper(coins, coins.length - 1, amount);

        return ans >= 10001 ? -1 : ans;
    }

    private int helper(int[] coins, int i, int amount) {
        if (amount < 0) {
            return 10001;
        }
        if (amount == 0) {
            return 0;
        }
        if (i == -1) {
            return 10001;
        }
        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }

        // Choose the coin or skip it
        dp[i][amount] = Math.min(1 + helper(coins, i, amount - coins[i]), helper(coins, i - 1, amount));
        return dp[i][amount];
    }
}
