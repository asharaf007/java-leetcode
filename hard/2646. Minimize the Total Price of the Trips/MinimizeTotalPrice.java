package Java.leetcodeSolution.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/minimize-the-total-price-of-the-trips/
public class MinimizeTotalPrice {
    public static void main(String[] args) {
        System.out.println(new MinimizeTotalPrice().
                minimumTotalPrice(4,new int[][]{{0,1},{1,2},{1,3}},new int[]{2,2,10,6},new int[][]{{0,3},{2,1},{2,3}}));
    }
    int[] count;
    List<Integer>[] adj;
    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        count=new int[n];
        adj=new List[n];
        Arrays.setAll(adj, i->new ArrayList<>());
        for(int[] edge:edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        for(int[] trip:trips){
            countVisits(trip[0],trip[1],-1);
        }
        int[] ans=dfs(0,-1,price);
        return Math.min(ans[0],ans[1]);
    }

    private boolean countVisits(int curr, int target,int parent) {
        count[curr]++;
        if(curr==target){
            return true;
        }
        for(int child : adj[curr]){
            if(child==parent){
                continue;
            }
            if(countVisits(child,target,curr)) return true;
        }
        count[curr]--;
        return false;
    }
    private int[] dfs(int curr,int parent,int[] price){
        int noHalfSum=0,minSum=0;
        for(int child:adj[curr]){
            if(child==parent){
                continue;
            }
            int[] sum=dfs(child,curr,price);
            minSum+=Math.min(sum[0],sum[1]);
            noHalfSum+=sum[0];
        }
        int ownSum=count[curr]*price[curr];
        return new int[]{ownSum+minSum,ownSum/2+noHalfSum};
    }
}
