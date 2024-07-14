package Java.leetcodeSolution.contest.week357;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/contest/weekly-contest-357/problems/check-if-it-is-possible-to-split-array/
public class SplitArray {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(4);
        nums.add(1);
        nums.add(3);
        nums.add(2);
        nums.add(4);
        System.out.println(canSplitArray(nums, 6));
    }

    public static boolean canSplitArray(List<Integer> nums, int m) {
        if (nums.size() <= 2) return true;
        for (int i = 0; i + 1 < nums.size(); i++) {
            if (nums.get(i) + nums.get(i + 1) >= m) return true;
        }
        return false;
    }
}

