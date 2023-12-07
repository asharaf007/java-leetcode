package Java.leetcodeSolution.medium;

import Java.OOPS.customDataStructures.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/
public class FlipBTtoMatchPOT {
    List<Integer> ans;
    int i=-1;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        ans=new ArrayList<>();
        if(solve(root,voyage)) return ans;
        ans=new ArrayList<>();
        ans.add(-1);
        return ans;
    }
    private boolean solve(TreeNode root, int[] v){
        if(root==null||root.val!=v[++i]) return false;
        if(root.left!=null){
            if(v[i+1]!=root.left.val){
                ans.add(root.val);
                TreeNode t=root.left;
                root.left=root.right;
                root.right=t;
            }
            if(!solve(root.left,v)) return false;
        }
        if(root.right==null) return true;
        return solve(root.right,v);
    }
}
