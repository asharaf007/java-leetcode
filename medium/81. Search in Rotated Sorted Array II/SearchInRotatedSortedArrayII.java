package Java.leetcodeSolution.medium;

//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1}, 3));
    }

    public static boolean search(int[] nums, int target) {
        int st = 0;
        int end = nums.length - 1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] == nums[st] && nums[st] == nums[end]) {
                st++;
                end--;
            } else if (nums[st] <= nums[mid]) {
                if (nums[st] <= target && nums[mid] > target) end = mid - 1;
                else st = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[end]) st = mid + 1;
                else end = mid - 1;
            }
        }
        return false;
    }

}
