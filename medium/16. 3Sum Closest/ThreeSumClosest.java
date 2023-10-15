package Java.leetcodeSolution.medium;

import java.util.Arrays;

//https://leetcode.com/problems/3sum-closest/
public class ThreeSumClosest {
    public static void main(String[] args) {
    System.out.println(threeSumClosest(new int[]{0,3,97,102,200},300));
    }
    public static int threeSumClosest(int[] nums, int target) {
        boolean flag=false;
        int ans=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int curr=nums[i]+nums[j]+nums[k];
                if(Math.abs(target-ans)>Math.abs(target-curr)) ans=curr;
                if(curr==target) return target;
                if(curr>target) k--;
                else j++;
            }
            if(ans>target){
                if(flag) return ans;
            }
            else flag=true;
        }
        return ans;
    }
}
