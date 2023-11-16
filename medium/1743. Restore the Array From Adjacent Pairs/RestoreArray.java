package Java.leetcodeSolution.medium;

import java.util.HashMap;
import java.util.HashSet;

public class RestoreArray {
    public int[] restoreArray(int[][] adjacentPairs) {
        int[] ans=new int[adjacentPairs.length+1];
        HashSet<Integer> set=new HashSet<Integer>();
        int i=0;
        for(int[] pair :adjacentPairs) {
            if(!set.contains(pair[0])) {
                ans[i++]=pair[0];
                set.add(pair[0]);
            }
            if(!set.contains(pair[1])) {
                ans[i++]=pair[1];
                set.add(pair[1]);
            }
        }
        return ans;
    }
}
