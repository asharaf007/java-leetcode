package Java.leetcodeSolutions.easy;
//Question Link Below
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class BuyAndSellStock {
    public static void main(String[] args) {
        int[] prices={3,2,6,5,0};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int buy=Integer.MAX_VALUE;//Max value
        int sell=0;//least value
        int profit=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<buy){
                buy=prices[i];
                sell=prices[i];
            }
            if(profit<prices[i]-buy){
                sell=prices[i];
                profit=prices[i]-buy;
            }
        }
        return profit;
    }
}
