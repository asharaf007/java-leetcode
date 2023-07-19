package Java.leetcodeSolutions.easy;
//Question Link Below
//https://leetcode.com/problems/single-number/

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums={4,2,3,2,3,1,4};
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            ans^=nums[i];
        }
        return ans;
    }
}
