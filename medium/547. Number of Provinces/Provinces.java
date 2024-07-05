//https://leetcode.com/problems/number-of-provinces/

import java.util.HashSet;
import java.util.Set;

public class Provinces {
    Set<Integer>[] graph;
    Set<Integer> done;
    int res;

    public int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        graph = new Set[length];
        done = new HashSet<>();
        for (int i = 0; i < length; i++) {
            graph[i] = new HashSet<>();
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    graph[i].add(j);
                }
            }
        }
        for (int i = 0; i < length; i++) {
            if (!done.contains(i)) {
                res++;
                dfs(i);
            }
        }
        return res;
    }

    // find connected components
    private void dfs(int node) {
        done.add(node);
        for (int child : graph[node]) {
            if (!done.contains(child)) {
                dfs(child);
            }
        }
    }
}
