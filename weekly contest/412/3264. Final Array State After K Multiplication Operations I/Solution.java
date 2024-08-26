//https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });

        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[]{nums[i], i});
        }

        while (!pq.isEmpty() && k > 0) {
            int[] peek = pq.poll();
            nums[peek[1]] = peek[0] * multiplier;
            pq.add(new int[]{nums[peek[1]],peek[1]});
            k--;
        }

        return nums;
    }
}
