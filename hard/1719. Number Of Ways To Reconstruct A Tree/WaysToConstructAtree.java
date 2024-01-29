package Java.leetcodeSolution.hard;
//https://leetcode.com/problems/number-of-ways-to-reconstruct-a-tree/
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WaysToConstructAtree {
    List[] graph;
    public int checkWays(int[][] pairs) {
        graph=new List[500];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Integer>();
        }
        Set<Integer> set=new HashSet<>();
        for(int[] pair:pairs){
            if(!set.contains(pair[0])) set.add(pair[0]);
            if(!set.contains(pair[1])) set.add(pair[1]);
            graph[pair[0]].add(pair[1]);
            graph[pair[1]].add(pair[0]);
        }
        return 5;
    }
}
