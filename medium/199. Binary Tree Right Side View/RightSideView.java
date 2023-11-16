package Java.leetcodeSolution.medium;

import Java.OOPS.customDataStructures.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//https://leetcode.com/problems/binary-tree-right-side-view/
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int count=q.size();
        while(!q.isEmpty()) {
            TreeNode node=q.poll();
            if(node.left!=null) q.add(node.left);
            if(node.right!=null) q.add(node.right);
            if(--count==0) {
                ans.add(node.val);
                count=q.size();
            }
        }
        return ans;
    }
}
