package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/
public class AllAntsFall {
    public int getLastMoment(int n, int[] left, int[] right) {
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int i=0;i<left.length;i++) if(left[i]>max) max=left[i];
        if(right.length==0) return max;
        for(int i=0;i<right.length;i++) if(right[i]<min) min=right[i];
        if(left.length==0) return n-min;
        return Math.max(max,n-min);
    }
}
