import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/sorting-three-groups/
public class SortThreeGroups{
    int[][] dp;
    public int minimumOperations(List<Integer> nums) {
        dp=new int[4][nums.size()+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(nums,0,0);
    }
    private int helper(List<Integer> nums,int prev,int index){
        if(index==nums.size()) return 0;
        if(dp[prev][index]!=-1) return dp[prev][index];
        dp[prev][index]=1+helper(nums,prev,index+1);
        if(nums.get(index)>=prev){
            dp[prev][index]=Math.min(dp[prev][index],helper(nums,nums.get(index),index+1));
        }
        return dp[prev][index];
    }
}