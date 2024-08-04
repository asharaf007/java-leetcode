//https://leetcode.com/problems/subarray-sum-equals-k/
public class SubArraySumEqual {
    public int subarraySum(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - n)) {
                count += map.get(sum - n);
            }
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        return count;
    }
}
