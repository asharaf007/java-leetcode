package Java.leetcodeSolution.hard;

import java.util.PriorityQueue;
//https://leetcode.com/problems/max-value-of-equation/
public class MaxValOfEqn {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int max=Integer.MIN_VALUE,n=points.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));
        for(int[] x:points){
            while(!pq.isEmpty()&&x[0]-pq.peek()[0]>k) pq.poll();
            if(!pq.isEmpty()) max=Math.max(max,x[0]+x[1]+pq.peek()[1]);
            pq.offer(new int[]{x[0],x[1]-x[0]});
        }
        return max;
    }
}
