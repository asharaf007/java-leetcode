//https://leetcode.com/problems/max-consecutive-ones/
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int prev=-1;
        int i=0;
        int ans=0;
        while(i<nums.length){
            if(nums[i]==0){
                ans=Math.max(ans,i-prev-1);
                prev=i;
            }
            i++;
        }
        return Math.max(ans,i-prev-1);
    }
}
