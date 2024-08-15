//https://leetcode.com/problems/maximum-average-subarray-i/
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        int i=0;
        while(i<k){
            sum+=nums[i++];
        }
        double max=sum;
        while(i<nums.length){
            sum+=nums[i]-nums[i-k];
            max=Math.max(max,sum);
            i++;
        }
        return max/k;
    }
}
