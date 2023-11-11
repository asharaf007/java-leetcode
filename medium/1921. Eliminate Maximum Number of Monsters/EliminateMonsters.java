package Java.leetcodeSolution.medium;

import java.util.Arrays;
//https://leetcode.com/problems/eliminate-maximum-number-of-monsters/
public class EliminateMonsters {
    public static void main(String[] args) {
        System.out.println(new EliminateMonsters().eliminateMaximum(new int[] {4,3,3,3,4},new int[ ]{1,1,1,1,4}));
    }
    public int eliminateMaximum(int[] dist, int[] speed) {
        for (int i = 0; i < dist.length; i++) dist[i] = (dist[i]-1)/speed[i];
        Arrays.sort(dist);
        int time=0;
        for(int i=0;i<dist.length&&time<=dist[i];i++,time++){}
        return time;
    }
}

