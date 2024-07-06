import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/create-components-with-same-value/
public class SameValue {
    public static void main(String[] args) {
        SameValue sameValue = new SameValue();
        int[] nums = { 6, 2, 2, 2, 6 };
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 1, 3 }, { 3, 4 } };
        System.out.println(sameValue.componentValue(nums, edges));
    }

    List<Integer>[] graph;
    boolean[] visited;
    int[] val;
    int target;

    public int componentValue(int[] nums, int[][] edges) {
        int length = nums.length;
        int totalSum = 0;
        val = nums;
        graph = new List[length];
        visited = new boolean[length];
        for (int i = 0; i < length; i++) {
            totalSum += nums[i];
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= (int) Math.sqrt(totalSum); i++) {
            if (totalSum % i == 0) {
                divisors.add(i);
                divisors.add(totalSum / i);
            }
        }
        divisors.sort((a, b) -> a - b);
        for (int num : divisors) {
            if (helper(num)) {
                return (totalSum / num) - 1;
            }
        }
        return 0;
    }

    private boolean helper(int target) {
        this.target = target;
        return dfs(0)[0] == 1;
    }

    private int[] dfs(int node) {
        visited[node] = true;
        int value = val[node];
        for (int child : graph[node]) {
            if (!visited[child]) {
                int[] subRes = dfs(child);
                if (subRes[0] == 0) {
                    value += subRes[1];
                }
            }
        }
        visited[node] = false;
        return new int[] { value == target ? 1 : 0, value };
    }
}