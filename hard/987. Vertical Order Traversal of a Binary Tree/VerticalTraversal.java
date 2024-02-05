package Java.leetcodeSolution.hard;
//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
import Java.OOPS.customDataStructures.tree.TreeNode;

import java.util.*;
import java.util.stream.Stream;

public class VerticalTraversal {
    class Node{
        int row;
        int val;
        Node(int row, int val){
            this.row = row;
            this.val = val;
        }
    }
    int minIndex=Integer.MAX_VALUE;
    int maxIndex=Integer.MIN_VALUE;
    Map<Integer, List<Node>> map=new HashMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(0,0,root);
        for(int i=minIndex;i<=maxIndex;i++){
            List<Integer> subList=new ArrayList<>();
            Stream<Node> nodeList=map.get(i).stream().sorted((a, b)->(a.row==b.row?Integer.compare(a.val,b.val):Integer.compare(a.row,b.row)));
            nodeList.forEach((node)->subList.add(node.val));
            ans.add(subList);
        }
        return ans;
    }
    void helper(int row,int col,TreeNode root){
        if(root==null){
            minIndex=Math.min(minIndex,col+1);
            maxIndex=Math.max(maxIndex,col-1);
            return;
        }
        map.putIfAbsent(col,new ArrayList<>());
        map.get(col).add(new Node(row,root.val));
        helper(row+1,col-1,root.left);
        helper(row+1,col+1,root.right);
    }
}
