package Java.leetcodeSolution.easy;
//Question Link Below
//https://leetcode.com/problems/pascals-triangle/

import java.util.*;

public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(generate(15));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listless = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        listless.add(first);
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            List<Integer> prevList = listless.get(i - 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(prevList.get(j) + prevList.get(j - 1));
                }
            }
            listless.add(list);
        }
        return listless;
    }
}
