package Java.leetcodeSolution.hard;

import java.util.*;

//https://leetcode.com/problems/count-number-of-possible-root-nodes/
public class CountPossibleRoot {
    public static void main(String[] args) {
        System.out.println(new CountPossibleRoot().rootCount(new int[][]{{0,1},{1,2},{1,3},{4,2}},new int[][]{{1,3},{0,1},{1,0},{2,4}},3));
    }
    Set<Integer>[] adj;
    Set<Integer>[] guessed;
    int[] parents;
    int rootCount=0;
    int leastRightGuess;
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        int n=edges.length+1;
        adj=new Set[n];
        guessed=new Set[n];
        for(int i=0;i<n;i++){
            adj[i]=new HashSet<>();
            guessed[i]=new HashSet<>();
        }
        for(int [] guess:edges){
            adj[guess[0]].add(guess[1]);
            adj[guess[1]].add(guess[0]);
        }
        for(int [] guess:guesses){
            guessed[guess[0]].add(guess[1]);
        }
        parents=new int[n];
        int rightGuess=0;
        dfs(0,-1);
        for(int i=1;i<n;i++){
            int parent=parents[i];
            if(guessed[parent].contains(i)){
                rightGuess++;
            }
        }
        leastRightGuess=k;
        dfs2(0,0,rightGuess);
        return rootCount;
    }
    private void dfs(int root,int parent){
        parents[root]=parent;
        for(int child:adj[root]){
            if(child==parent){
                continue;
            }
            dfs(child,root);
        }
    }
    private void dfs2(int root,int parent,int rightGuess){
        if(guessed[root].contains(parent)) rightGuess++;
        if(guessed[parent].contains(root)) rightGuess--;
        if(rightGuess>=leastRightGuess) rootCount++;
        for(int child:adj[root]){
            if(child==parent) continue;
            dfs2(child,root,rightGuess);
        }
    }
}
