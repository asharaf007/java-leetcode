package Java.leetcodeSolution.contest.week355;

//https://leetcode.com/contest/weekly-contest-355/problems/largest-element-in-an-array-after-merge-operations/
public class LeetCode2789 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 9, 3, 5, 16, 1};
        System.out.println(maxArrayValue(nums));
    }

    public static long maxArrayValue(int[] nums) {
        long ans = 0;
        long currMax = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            if (num > currMax) {
                currMax = 0;
            }
            currMax += num;
            ans = Math.max(ans, currMax);
        }
        return ans;
    }
}
