package Java.leetcodeSolution.easy;

//https://leetcode.com/problems/binary-search/
public class BinarySearch {
    public int search(int[] nums, int target) {
        int st = 0;
        int end = nums.length - 1;
        int mid = st + (end - st) / 2;
        while (st <= end) {
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
            mid = st + (end - st) / 2;
        }
        return -1;
    }
}
