package Java.leetcodeSolution.medium;

import Java.OOPS.customDataStructures.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
public class AllNodesDistanceK {
    HashMap<Integer,List<Integer>> map=new HashMap<>();
    List<Integer> ans=new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root,null);
        solve(target.val,0,k,target.val);
        return ans;
    }
    private void dfs(TreeNode root,Integer prev){
        if(root==null) return;
        List<Integer> link=new ArrayList<>();
        if(root.left!=null) link.add(root.left.val);
        if(root.right!=null) link.add(root.right.val);
        if(prev!=null) link.add(prev);
        map.put(root.val,link);
        dfs(root.left,root.val);
        dfs(root.right,root.val);
    }
    private void solve(int target,int length,int k,int prev){
        if(length==k){
            ans.add(target);
            return;
        }
        List<Integer> l=map.get(target);
        for(int i=0;i<l.size();i++){
            if(l.get(i)!=prev)solve(l.get(i),length+1,k,target);
        }
    }
}
