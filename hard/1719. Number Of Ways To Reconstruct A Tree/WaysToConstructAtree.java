
//https://leetcode.com/problems/number-of-ways-to-reconstruct-a-tree/
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WaysToConstructAtree {
    public static void main(String[] args) {
        WaysToConstructAtree waysToConstructAtree = new WaysToConstructAtree();
        int[][] pairs = { { 4, 10 }, { 13, 14 }, { 2, 5 }, { 6, 11 }, { 12, 13 }, {
                6, 8 }, { 1, 5 }, { 13, 15 },
                { 5, 13 }, { 4, 11 }, { 7, 13 }, { 1, 12 }, { 4, 8 }, { 6, 15 }, { 8, 10 }, {
                        2, 6 },
                { 2, 13 },
                { 1, 6 }, { 11, 13 }, { 10, 12 }, { 6, 9 }, { 2, 8 }, { 5, 10 }, { 4, 13 }, {
                        3, 13 },
                { 5, 6 },
                { 6, 10 }, { 10, 13 }, { 2, 10 }, { 3, 6 }, { 9, 13 }, { 6, 7 }, { 3, 9 }, {
                        7, 8 },
                { 8, 13 },
                { 5, 8 }, { 1, 13 }, { 8, 11 }, { 6, 13 }, { 4, 6 }, { 6, 12 }, { 1, 10 }, {
                        1, 8 },
                { 10, 11 },
                { 8, 12 } };

        System.out.println(waysToConstructAtree.checkWays(pairs));
    }

    Set<Integer>[] graph;

    public int checkWays(int[][] pairs) {
        graph = new Set[501];
        for (int i = 0; i < 501; i++) {
            graph[i] = new HashSet<>();
        }
        Set<Integer> set = new HashSet<>();
        for (int[] pair : pairs) {
            set.add(pair[0]);
            set.add(pair[1]);
            graph[pair[0]].add(pair[1]);
            graph[pair[1]].add(pair[0]);
        }
        return helper(set);
    }

    private int helper(Set<Integer> set) {
        int size = set.size();
        int root = -1;
        int rootCount = 0;
        for (int i : set) {
            if (graph[i].size() == size - 1) {
                root = i;
                rootCount++;
            }
        }
        if (rootCount == 0)
            return 0;
        for (int node : set) {
            graph[node].remove(root);
        }
        int i = 0;
        List<Set<Integer>> components = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for (int node : set) {
            if (node != root && !seen.contains(node)) {
                components.add(new HashSet<>());
                dfs(node, i++, components, seen);
            }
        }
        for (Set<Integer> comp : components) {
            int sub = helper(comp);
            if (sub == 0)
                return 0;
            if (sub == 2) {
                rootCount++;
            }
        }
        return rootCount == 1 ? 1 : 2;
    }

    void dfs(int node, int i, List<Set<Integer>> components, Set<Integer> seen) {
        components.get(i).add(node);
        seen.add(node);
        for (int child : graph[node]) {
            if (!seen.contains(child)) {
                dfs(child, i, components, seen);
            }
        }
    }
}
