package Java.leetcodeSolution.medium;
//Question Link Below
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

public class MaxProfit {
    public static void main(String[] args) {
        int[] nums = {397, 6621, 4997, 7506, 8918, 1662, 9187, 3278, 3890, 514, 18, 9305, 93, 5508, 3031, 2692, 6019, 1134, 1691, 4949, 5071, 7};
        System.out.println(maxProfit(nums));
    }

    public static int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
        // return solve(prices,0,Integer.MAX_VALUE,0);
    }
}
