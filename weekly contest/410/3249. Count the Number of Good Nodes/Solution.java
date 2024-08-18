//https://leetcode.com/problems/count-the-number-of-good-nodes/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int ans;
    List<Integer>[] graph;
    public int countGoodNodes(int[][] edges) {
        ans=0;
        graph=new List[edges.length+1];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        dfs(0,0);
        return ans;
    }
    private int dfs(int node,int parent){
        List<Integer> counts=new ArrayList()<>();
        for(int child:graph[node]){
            if(child==parent){
                continue;
            }
            counts.add(dfs(child,node));
        }
        if(counts.size()==0){
            ans++;
            return 1;
        }
        boolean isSame=true;
        int childCount=counts.get(0);
        int count=1;
        for(int num:counts){
            count+=num;
            if(num!=childCount){
                isSame=false;
            }
        }
        if(isSame){
            ans++;
        }
        return count;
    }
}
