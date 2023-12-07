package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/most-profitable-path-in-a-tree/submissions/1110264700/
import java.util.ArrayList;
import java.util.List;

public class MostProfitablePathInBT {
    List<Integer>[] links;
    int max = Integer.MIN_VALUE;
    boolean[] visited;
    List<Integer> path;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        path=new ArrayList<>();
        links = new ArrayList[amount.length];
        visited=new boolean[amount.length];
        for (int i = 0; i < links.length; i++) links[i] = new ArrayList<>();
        for (int j = 0; j < edges.length; j++) {
            links[edges[j][0]].add(edges[j][1]);
            links[edges[j][1]].add(edges[j][0]);
        }
        //find path of bob
        bobPath(bob);
        System.out.println(path);
        //find maximum income of alice
        solve(0, 0, amount, 0);
        return max;
    }

    private void solve(int alice, int bobIndex, int[] amount, int income) {
        if(bobIndex<path.size()-1&&alice==path.get(bobIndex)){
            income+=amount[alice]/2;
        }
        else income+=amount[alice];
        List<Integer> l=links[alice];
        int b=amount[path.get(bobIndex)];
        amount[path.get(bobIndex)]=0;
        visited[alice]=true;
        int count=0;
        for(int i=0; i<l.size(); i++) {
            if(!visited[l.get(i)]) {
                count++;
                if(bobIndex==path.size()-1) solve(l.get(i), bobIndex, amount, income);
                else solve(l.get(i),bobIndex+1,amount,income);
            }
        }
        amount[path.get(bobIndex)]=b;
        visited[alice]=false;
        if(count==0) max=Math.max(max,income);
    }
    private boolean bobPath(int target){
        path.add(target);
        if(target==0) return true;
        visited[target]=true;
        List<Integer> link=links[target];
        for(int i=0; i<link.size(); i++) {
            if (!visited[link.get(i)]&&bobPath(link.get(i))) {
                visited[target]=false;
                return true;
            }
        }
        path.remove(path.size()-1);
        visited[target]=false;
        return false;
    }
}
