package Java.leetcodeSolution.medium;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/largest-number/
public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        String[] sArray = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sArray[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(sArray, new FirstComparator());
        String ans = "";
        for (int i = sArray.length - 1; i >= 0; i--)
            ans = ans + sArray[i];
        if (ans.charAt(0) == '0') return "0";
        return ans;
    }
}

class FirstComparator implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        return (str1 + str2).compareTo(str2 + str1);
    }
}
