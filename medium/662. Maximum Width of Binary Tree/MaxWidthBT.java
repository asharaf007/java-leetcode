package Java.leetcodeSolution.medium;

import Java.OOPS.customDataStructures.tree.TreeNode;

import java.util.*;

//https://leetcode.com/problems/maximum-width-of-binary-tree/
public class MaxWidthBT {
    class Node{
        TreeNode node;
        int index;
        Node(TreeNode node, int index){
            this.node=node;
            this.index=index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int max=1;
        Queue<Node> q=new LinkedList<>();
        q.offer(new Node(root,0));
        while(!q.isEmpty()) {
            int size=q.size();
            int st=0,end=0;
            for(int i=0;i<size;i++) {
                Node curr=q.poll();
                TreeNode node=curr.node;
                int idx=curr.index;
                if(i==0) st=idx;
                if(i==size-1) end=idx;
                if(node.left!=null) q.offer(new Node(node.left,2*idx+1));
                if(node.right!=null) q.offer(new Node(node.right,2*idx+2));
            }
            max=Math.max(max,end-st+1);
        }
        return max;
    }
}
