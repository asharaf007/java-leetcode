package Java.leetcodeSolution.easy;

import Java.OOPS.customDataStructures.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/cousins-in-binary-tree/
public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root.val==x||root.val==y) return false;
        int level=0,xLevel=0,yLevel=0;
        TreeNode xParent=null,yParent=null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int size=q.size();
        while(!q.isEmpty()&&(xLevel==0||yLevel==0)) {
            TreeNode node=q.poll();
            if(node.left!=null) {
                q.offer(node.left);
                if(node.left.val==x) {
                    xLevel=level;
                    xParent=node;
                }
                if(node.left.val==y) {
                    yLevel=level;
                    yParent=node;
                }
            }
            if(node.right!=null) {
                q.offer(node.right);
                if(node.right.val==x) {
                    xLevel=level;
                    xParent=node;
                }
                if(node.right.val==y) {
                    yLevel=level;
                    yParent=node;
                }
            }
            if(--size==0) {
                size=q.size();
                level++;
            }
        }
        return xParent!=yParent&&xLevel==yLevel;
    }
}
