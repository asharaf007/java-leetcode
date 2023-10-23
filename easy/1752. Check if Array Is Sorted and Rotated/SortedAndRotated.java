package Java.leetcodeSolution.easy;

//https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
public class SortedAndRotated {
    public boolean check(int[] nums) {
        int size = nums.length;
        int i = 0;
        int count = 0;
        while (i < nums.length) {
            if (nums[i] > nums[(i + 1) % size]) {
                count++;
            }
            if (count == 2) {
                return false;
            }
            i++;
        }
        return true;
    }
}
