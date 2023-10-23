package Java.leetcodeSolution.medium;

//Question Link Below
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FirstNLastPosOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        nums = searchRange(nums, 8);
        System.out.println(nums[0]);
        System.out.println(nums[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = firstPos(nums, target, 0, nums.length - 1);
        ans[1] = secondPos(nums, target, 0, nums.length - 1);
        return ans;
    }

    public static int firstPos(int[] nums, int target, int st, int end) {
        int mid = st + (end - st) / 2;
        int ans = -1;
        while (st <= end) {
            if (nums[mid] == target) {
                ans = mid;
                end = mid - 1;
            }
            if (nums[mid] < target) {
                st = mid + 1;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            }
            mid = st + (end - st) / 2;
        }
        return ans;
    }

    public static int secondPos(int[] nums, int target, int st, int end) {
        int mid = st + (end - st) / 2;
        int ans = -1;
        while (st <= end) {
            if (nums[mid] == target) {
                ans = mid;
                st = mid + 1;
            }
            if (nums[mid] < target) {
                st = mid + 1;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            }
            mid = st + (end - st) / 2;
        }
        return ans;
    }
}
