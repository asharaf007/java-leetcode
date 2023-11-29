package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/
import Java.OOPS.customDataStructures.tree.TreeNode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestSumInBT {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q= new LinkedList<>();
        PriorityQueue<Long> pq=new PriorityQueue<>((a,b) ->b.compareTo(a));
        q.offer(root);
        while(!q.isEmpty()) {
            int size=q.size();
            long sum=0;
            for(int i=0; i<size; i++) {
                TreeNode curr=q.poll();
                sum+=curr.val;
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            pq.offer(sum);
        }
        if(k>pq.size()) return -1;
        for(int i=1; i<k; i++) pq.poll();
        return pq.peek();
    }
}
