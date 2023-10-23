package Java.leetcodeSolution.medium;

import java.util.*;

//Question link below
//https://leetcode.com/problems/top-k-frequent-elements/
public class TopKFreqElements {
    public static void main(String[] args) {
        int[] nums = {1, 4, 7, 3, 4, 7, 5, 7, 3};
        System.out.print(Arrays.toString(topKFrequent(nums, 1)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> set = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue().compareTo(a.getValue()));
        int[] ans = new int[k];
        for (int num :
                nums) {
            if (set.containsKey(num)) {
                set.put(num, set.get(num) + 1);
            } else {
                set.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry :
                set.entrySet()) {
            pq.add(entry);
        }
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }
}