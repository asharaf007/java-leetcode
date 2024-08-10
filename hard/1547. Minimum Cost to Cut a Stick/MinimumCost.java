//https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
public class MinimumCost {
    int[] cuts;
    int[][] dp;

    public int minCost(int n, int[] cuts) {
        int[] allCuts = new int[cuts.length + 2];
        allCuts[0] = 0;
        allCuts[allCuts.length - 1] = n;
        System.arraycopy(cuts, 0, allCuts, 1, cuts.length);
        Arrays.sort(allCuts);
        this.cuts = allCuts;

        int len = cuts.length + 2;
        dp = new int[len][len];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, len - 1);
    }

    public int solve(int i, int j) {
        if (i + 1 == j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int minCost = Integer.MAX_VALUE;

        for (int k = i + 1; k < j; k++) {
            int cost = cuts[j] - cuts[i] + solve(i, k) + solve(k, j);
            minCost = Math.min(minCost, cost);
        }

        dp[i][j] = minCost;
        return minCost;
    }
}
