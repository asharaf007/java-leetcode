package Java.leetcodeSolution.medium;

import java.util.Arrays;

//https://leetcode.com/problems/rotate-array/
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        new RotateArray().rotate(nums, 8);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if (k == 0) return;
        int stIndex = 0, count = 0, curr = 0,prevVal = nums[curr];
        while (count < n) {
            curr = (curr + k) % n;
            int temp = nums[curr];
            nums[curr] = prevVal;
            prevVal = temp;
            count++;
            if (curr == stIndex) prevVal = nums[curr = ++stIndex];
        }
    }
}
