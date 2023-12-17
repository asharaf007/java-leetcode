package Java.leetcodeSolution.hard;

import java.util.*;

//https://leetcode.com/problems/collect-coins-in-a-tree/
public class CollectCoinsInAtree {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n=coins.length;
        List<Integer>[] adjList=new List[n];
        for(int i=0;i<n;i++) adjList[i]=new ArrayList<>();
        //create adjascency matrix
        for(int[] edge:edges){
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        Queue<Integer> q=new LinkedList<>();
        Queue<Integer> q2=new LinkedList<>();
        for(int i=0; i<n; i++) q.offer(i);
        //remove leaf nodes without coin
        while(!q.isEmpty()){
            int i=q.poll();
            if(adjList[i].size()==1) {
                if(coins[i]==1){
                    q2.offer(i);
                    continue;
                }
                int parent=adjList[i].get(0);
                q.offer(parent);
                adjList[i].remove(0);
                adjList[parent].remove(Integer.valueOf(i));
            }
        }
        //remove leaf nodes and store its parent for next trim
        while(!q2.isEmpty()) {
            int i=q2.poll();
            if(adjList[i].size()==1){
                int parent=adjList[i].get(0);
                q.offer(parent);
                adjList[i].remove(0);
                adjList[parent].remove(Integer.valueOf(i));
            }
        }
        Set<Integer> set=new HashSet<>();
        while(!q.isEmpty()){
            int i=q.poll();
            if(!set.contains(i)&&adjList[i].size()==1){
                int parent=adjList[i].get(0);
                set.add(parent);
                adjList[i].remove(0);
                adjList[parent].remove(Integer.valueOf(i));
            }
        }
        for(int i=0; i<adjList.length;i++) if(adjList[i].size()>0) return dfs(i,adjList,-1);
        return 0;
    }
    private int dfs(int i,List[] adj,int parent) {
        List<Integer> l = adj[i];
        int count = 0, ans = 0;
        for (int n : l) {
            if (n == parent) continue;
            count++;
            ans += dfs(n, adj, i);
        }
        return 2 * count + ans;
    }
}
