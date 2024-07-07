import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/longest-path-with-different-adjacent-characters/
public class LongestPath {
    int ans;
    List<Integer>[] graph;
    String s;

    public int longestPath(int[] parent, String s) {
        int length = parent.length;
        graph = new List[length];
        this.s = s;
        for (int i = 0; i < length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < length; i++) {
            graph[parent[i]].add(i);
        }
        dfs(0);
        return ans;
    }

    private int dfs(int root) {
        List<Integer> subResults = new ArrayList<>();
        for (int child : graph[root]) {
            int res = dfs(child);
            if (s.charAt(child) != s.charAt(root)) {
                subResults.add(res);
            }
        }
        int first = 0, second = 0;
        for (int i = 0; i < subResults.size(); i++) {
            int num = subResults.get(i);
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second) {
                second = num;
            }
        }
        ans = Math.max(ans, first + second + 1);
        return 1 + first;
    }
}
