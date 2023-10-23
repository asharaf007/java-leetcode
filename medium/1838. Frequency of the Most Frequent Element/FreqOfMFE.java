package Java.leetcodeSolution.medium;

import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/problems/frequency-of-the-most-frequent-element/
public class FreqOfMFE {
    public static void main(String[] args) {
        System.out.println(new FreqOfMFE().maxFrequency(new int[]{3, 9, 6}, 2));
    }

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1, n = nums.length;
        int l = 0, r = 1, sum = 0;
        while (r < n) {
            sum += (nums[r] - nums[r - 1]) * (r - l);
            while (sum > k) sum -= nums[r] - nums[l++];
            ans = Math.max(ans, r++ - l + 1);
        }
        return ans;
    }
}
