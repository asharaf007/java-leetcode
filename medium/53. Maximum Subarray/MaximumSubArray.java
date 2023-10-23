package Java.leetcodeSolution.medium;

//Question Link Below
//https://leetcode.com/problems/maximum-subarray/
public class MaximumSubArray {
    public static void main(String[] args) {
        int[] nums = {5, 4, -1, 7, 8};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = -100000;
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (currSum > maxSum) {
                maxSum = currSum;
            }
            if (currSum < 0) currSum = 0;
        }
        return maxSum;
    }
}
