package Java.leetcodeSolution.medium;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
public class KthElementInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(kthSmallest(matrix,8));
    }
    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int[] a:matrix){
            for(int b:a){
                pq.add(b);
            }
        }
        while(--k>0) pq.remove();
        return pq.remove();
    }
}
