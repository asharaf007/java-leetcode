package Java.leetcodeSolution.medium;

import Java.OOPS.customDataStructures.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/closest-nodes-queries-in-a-binary-search-tree/
public class ClosestNodesQuery {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> nodes=new ArrayList<>();
        inOrder(root,nodes);
        List<List<Integer>> ans=new ArrayList<>();
        for(int num : queries) {
            Double index=binarySearch(nodes,num);
            ans.add(List.of(index<0?-1:nodes.get((int)Math.floor(index)),index>nodes.size()-1?-1:nodes.get((int)Math.ceil(index))));
        }
        return ans;
    }
    private void inOrder(TreeNode root,List<Integer> list){
        if(root==null) return;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
    private Double binarySearch(List<Integer> list,int target){
        int st=0;
        int end=list.size()-1;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(list.get(mid)==target) return (double)mid;
            if(list.get(mid)<target) st=mid+1;
            else end=mid-1;
        }
        return (st+end)/2.0;
    }
}
