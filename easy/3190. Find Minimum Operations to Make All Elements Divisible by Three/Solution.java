//https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/
public class Solution {

    public int minimumOperations(int[] arr) {
        int res = 0;
        for (int num : arr) {
            int remainder = num % 3;
            res += remainder == 0 ? 0 : 1;
        }
        return res;
    }
}