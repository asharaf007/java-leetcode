import java.util.*;
//https://leetcode.com/problems/minimum-score-after-removals-on-a-tree/description/
public class MinimumScore {
    public static void main(String[] args) {
        int [] nums=new int[]{9,14,2,1};
        int[][] edges=new  int[][]{{2,3},{3,0},{3,1}};
        System.out.println();
        System.out.println("the result is :: "+new MinimumScore().minimumScore(nums,edges));
    }
    
    List<Integer>[] graph;
    int[] xor;
    boolean[][] isAncestor;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = edges.length + 1;
        graph = new List[n];
        xor = new int[n];
        isAncestor = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            xor[i] = nums[i];
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        dfs(0, 0, nums);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (i == j)
                    continue;
                int a, b, c;
                if (isAncestor[i][j]) {
                    a = xor[j];
                    b = xor[i] ^ a;
                } else if (isAncestor[j][i]) {
                    a = xor[i];
                    b = xor[j] ^ a;
                } else {
                    a = xor[i];
                    b = xor[j];
                }
                c = xor[0] ^ a ^ b;
                min = Math.min(min, getScore(a, b, c));
            }
        }
        return min;
    }

    private int dfs(int node, int parent, int[] nums) {
        markAncestor(node, parent, node);
        for (int child : graph[node]) {
            if (child == parent)
                continue;
            xor[node] ^= dfs(child, node, nums);
        }
        return xor[node];
    }

    private void markAncestor(int node, int parent, int ancestor) {
        isAncestor[ancestor][node] = true;
        for (int child : graph[node]) {
            if (child == parent)
                continue;
            markAncestor(child, node, ancestor);
        }
    }

    private int getScore(int a, int b, int c) {
        int max = Math.max(Math.max(a, b), c);
        int min = Math.min(Math.min(a, b), c);
        return max - min;
    }

}