package Java.leetcodeSolution.medium;

//Question Link Below
//https://leetcode.com/problems/gas-station/
public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int currGas = 0;
            int count = 0;
            for (int j = i; j < n + i; j++) {
                currGas += gas[j % n];
                if (currGas >= cost[j % n]) {
                    currGas -= cost[j % n];
                    count++;
                } else {
                    break;
                }
            }
            if (count == n) {
                return i;
            }
        }
        return ans;
    }
}
