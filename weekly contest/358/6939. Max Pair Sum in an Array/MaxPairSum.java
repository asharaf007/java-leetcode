package Java.leetcodeSolution.contest.week358;

//https://leetcode.com/contest/weekly-contest-358/problems/max-pair-sum-in-an-array/
public class MaxPairSum {
    public static void main(String[] args) {
        int[] nums = {71, 17, 3, 4};
        System.out.println(maxSum(nums));
    }

    public static int maxSum(int[] nums) {
        int ans = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (getDigit(nums[i]) == getDigit(nums[j])) {
                    ans = Math.max(ans, nums[i] + nums[j]);
                }
            }
        }
        return ans;
    }

    private static int getDigit(int num) {
        int digit = 0;
        while (num > 0) {
            digit = Math.max(digit, num % 10);
            num /= 10;
        }
        return digit;
    }
}
