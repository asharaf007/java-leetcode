package Java.leetcodeSolution.easy;
//https://leetcode.com/problems/sort-array-by-parity-ii/

import java.util.Arrays;
import java.util.Stack;

public class SortArrayByParityII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParityII(new int[]{2, 3, 1, 1, 4, 0, 0, 4, 3, 3})));
    }

    public static int[] sortArrayByParityII(int[] nums) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i] > i ? nums[i] - i : i - nums[i];
            if (num % 2 == 1) {
                if (st.isEmpty() || ((i - st.peek()) % 2 == 0)) st.push(i);
                else {
                    int temp = nums[st.peek()];
                    nums[st.pop()] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return nums;
    }
}
