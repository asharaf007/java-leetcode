package Java.leetcodeSolution.hard;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
public class MinInRSArrayII {
    public static void main(String[] args) {
        System.out.println(new MinInRSArrayII().findMin(new int[]{4, 4, 4, 1, 2, 4}));
    }

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == nums[right]) right--;
            else if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        return nums[right];
    }
}
