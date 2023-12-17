package Java.leetcodeSolution.hard;

import java.util.*;

//https://leetcode.com/problems/tree-of-coprimes/
public class TreeOfCoPrimes {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TreeOfCoPrimes().getCoprimes(new int[] {5,6,10,2,3,6,15},new int[][]{{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}})));
    }
    Set<Integer>[] coprimes;
    Set<Integer>[] adj;
    int[] level;
    int[] ans;
    int[] src;
    public int[] getCoprimes(int[] nums, int[][] edges) {
        int n=nums.length;
        coprimes=new Set[51];
        adj=new Set[n];
        level=new int[51];
        src=new int[51];
        ans=new int[n];
        for(int i=0; i<n; i++)adj[i]=new HashSet<>();
        for(int i=0; i<51; i++){
            level[i]=-1;
            coprimes[i]=new HashSet<>();
        }
        for(int i=1;i<=50;i++)for(int j=1;j<=50;j++)if(coprimes(i,j)) coprimes[i].add(j);
        for(int[] edge:edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        dfs(0,new HashSet<>(),-1,nums,0);
        return ans;
    }
    private void dfs(int node, Set<Integer> ancest, int parent, int[] nums,int currLvl){
        int lvl=-1,source=-1;
        for(int num:coprimes[nums[node]]){
            if(ancest.contains(num)&&level[num]>lvl){
                lvl=level[num];
                source=src[num];
            }
        }
        ans[node]=source;
        int prevSrc=src[nums[node]];
        int prevLvl=level[nums[node]];
        src[nums[node]]=node;
        level[nums[node]]=currLvl;
        if(!ancest.contains(nums[node])) ancest.add(nums[node]);
        for(int link:adj[node]){
            if(link==parent) continue;
            dfs(link,ancest,node,nums,currLvl+1);
        }
        if(prevLvl==-1) ancest.remove(nums[node]);
        level[nums[node]]=prevLvl;
        src[nums[node]]=prevSrc;
    }
    private boolean coprimes(int a,int b){
        if(a==0) return b==1;
        return coprimes(b%a,a);
    }
}
