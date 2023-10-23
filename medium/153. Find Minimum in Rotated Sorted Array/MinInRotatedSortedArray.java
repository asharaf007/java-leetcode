package Java.leetcodeSolution.medium;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class MinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int st = 0, end = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (nums[mid] >= nums[st]) {
                min = Math.min(min, nums[st]);
                st = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                end = mid - 1;
            }
        }
        return min;
    }
}
