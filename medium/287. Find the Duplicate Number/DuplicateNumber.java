package Java.leetcodeSolution.medium;

//https://leetcode.com/problems/find-the-duplicate-number/
public class DuplicateNumber {
    public static void main(String[] args) {
        System.out.println(new DuplicateNumber().findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }

    public int findDuplicate(int[] nums) {
        int n = nums.length, i = 0;
        while (i < n) {
            int crct = nums[i] - 1;
            if (nums[i] != nums[crct]) {
                int temp = nums[i];
                nums[i] = nums[crct];
                nums[crct] = temp;
            } else if (nums[i] != i + 1) return nums[i];
            else i++;
        }
        return -1;
    }
}
