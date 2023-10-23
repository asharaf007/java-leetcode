package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/gray-code/

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public static void main(String[] args) {
        System.out.println(grayCode(5));
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        int adder = 1;
        while (n > 0) {
            for (int i = adder - 1; i >= 0; i--) ans.add(adder + ans.get(i));
            n--;
            adder *= 2;
        }
        return ans;
    }
}
