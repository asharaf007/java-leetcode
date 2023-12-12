package Java.leetcodeSolution.hard;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/frog-position-after-t-seconds/
public class FrogPosAfterTsec {
    List<Integer>[] adj;
    int time;
    public double frogPosition(int n, int[][] edges, int t, int target) {
        time=t;
        adj = new List[n+1];
        for(int i=0; i<=n; i++)adj[i]=new ArrayList<>();
        for(int i=0; i<edges.length; i++){
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        adj[1].add(-1);
        return probability(1,target,0,-1);
    }
    private double probability(int node,int target,int t,int parent){
        List<Integer> adjList=adj[node];
        int childCount=adjList.size()-1;
        if(t==time||childCount==0) return node==target?1.0:0.0;
        double prob=0.0;
        for(int child : adjList){
            if(child==parent) continue;
            prob+=probability(child,target,t+1,node);
        }
        return prob/childCount;
    }
}
