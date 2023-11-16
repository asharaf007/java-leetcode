package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
import Java.OOPS.customDataStructures.tree.TreeNode;

import java.util.*;

public class BFSII {
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        List<Integer> l=new ArrayList<>();
        int count=q.size();
        while(!q.isEmpty()) {
            TreeNode node=q.poll();
            l.add(node.val);
            if(node.left!=null) q.add(node.left);
            if(node.right!=null) q.add(node.right);
            if(--count==0) {
                ans.add(l);
                l=new ArrayList<>();
                count=q.size();
            }
        }
        return ans.reversed();
    }
}
