package Java.leetcodeSolution.medium;

import java.util.Arrays;

//https://leetcode.com/problems/next-permutation/
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 5, 5, 5};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) j--;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        i++;
        int j = nums.length - 1;
        while (i < j) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++;
            j--;
        }
    }
}
