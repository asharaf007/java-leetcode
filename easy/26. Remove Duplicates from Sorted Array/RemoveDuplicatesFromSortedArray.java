package Java.leetcodeSolution.easy;
//Question Link Below
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    }

    public int removeDuplicates(int[] nums) {
        int prevNum = nums[0];
        int k = 1;
        int i = 1;
        int j = 1;
        while (j < nums.length) {
            while (j < nums.length && nums[j] == prevNum) {
                j++;
            }
            if (j == nums.length) {
                break;
            }
            nums[i] = nums[j];
            prevNum = nums[j];
            i++;
            j++;
            k++;
        }
        return k;
    }
}
