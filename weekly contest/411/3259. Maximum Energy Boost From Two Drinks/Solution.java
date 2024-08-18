import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/maximum-energy-boost-from-two-drinks/
class Solution {
    int[] A;
    int[] B;
    Map<String, Long> memo;

    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        A = energyDrinkA;
        B = energyDrinkB;
        memo = new HashMap<>();
        return Math.max(helper(0, true, A.length), helper(0, false, B.length));
    }

    private long helper(int index, boolean isA, int hour) {
        if (hour == 0) {
            return 0;
        }
        String key = index + "," + (isA ? 1 : 0) + "," + hour;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        long first = (isA ? A[index] : B[index]) + helper(index + 1, isA, hour - 1);
        long second = helper(index + 1, !isA, hour - 1);
        long result = Math.max(first, second);
        memo.put(key, result);
        return result;
    }
}