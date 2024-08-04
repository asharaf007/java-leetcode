//https://leetcode.com/problems/longest-consecutive-sequence/
public class ConsecSeq {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> done = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = 0;
        for (int num : set) {
            if (done.contains(num)) {
                continue;
            }
            int curr = num;
            while (set.contains(++curr)) {
                done.add(curr);
            }
            max = Math.max(curr - num, max);
        }
        return max;
    }
}
