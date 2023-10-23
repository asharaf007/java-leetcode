package Java.leetcodeSolution.medium;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1, 5, 5, 6, 6, 7, 7}));
    }

    public static int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) left = mid + 2;
                else right = mid;
            } else if (nums[mid] == nums[mid - 1]) left = mid + 1;
            else right = mid;
        }
        return nums[right];
    }
}
