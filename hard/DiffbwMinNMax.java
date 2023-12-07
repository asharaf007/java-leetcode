package Java.leetcodeSolution.hard;
//https://leetcode.com/problems/difference-between-maximum-and-minimum-price-sum/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class DiffbwMinNMax {
    List<Integer>[] edge;
    Map<Integer,Integer>[]dp;
    public long maxOutput(int n, int[][] edges, int[] price) {
        edge=new List[n];
        dp=new Map[n];
        for(int i=0;i<n;i++){
            dp[i] =new HashMap<>();
            edge[i] = new ArrayList();
        }
        for(int i=0;i<edges.length;i++){
            edge[edges[i][0]].add(edges[i][1]);
            edge[edges[i][1]].add(edges[i][0]);
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,maxPathVal(i,i,price)-price[i]);
            for(int j=0;j<edge[i].size();j++)
            max=Math.max(max,maxPathVal(i,edge[i].get(j),price)-price[i]);
        }
        return max;
    }
    private int maxPathVal(int vertex,int parent,int[] price) {
        if(dp[vertex].getOrDefault(parent,0)!=0) return dp[vertex].get(parent);
        int max=0;
        List<Integer> l=edge[vertex];
        for(int i=0;i<l.size();i++){
            if(l.get(i)==parent)continue;
            max=Math.max(max,maxPathVal(l.get(i),vertex,price));
        }
        return dp[vertex].put(parent,price[vertex]+max);
    }
}
