package Java.leetcodeSolution.easy;
//https://leetcode.com/problems/rank-transform-of-an-array/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTransform {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) temp[i] = arr[i];
        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : temp) map.putIfAbsent(x, map.size() + 1);
        for (int i = 0; i < arr.length; i++) arr[i] = map.get(arr[i]);
        return arr;
    }
}
