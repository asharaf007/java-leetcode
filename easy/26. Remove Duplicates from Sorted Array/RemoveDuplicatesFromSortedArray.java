package Java.leetcodeSolution.easy;
//Question Link Below
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    }

    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }
}
