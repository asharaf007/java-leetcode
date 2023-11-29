package Java.OOPS.customDataStructures.tree.segmentTree;

import java.util.Scanner;

public class SegmentTree {
    //IMPLEMENTATION BELOW
    private static class Node{
        int qsi;
        int qei;
        int val;
        Node left;
        Node right;
        public Node(int qsi,int qei) {
            this.qsi = qsi;
            this.qei = qei;
        }
    }
    private Node root;
    public SegmentTree(){}
    public SegmentTree(int[] arr) {
        root=populate(arr);
    }
    Scanner in=new Scanner(System.in);
    public Node populate(int[] arr){
        return populate(arr,0,arr.length-1);
    }
    private Node populate(int[] arr,int i,int j) {
        Node node=new Node(i,j);
        if(i==j){
            node.val=arr[i];
            return node;
        }
        int mid=i+(j-i)/2;
        node.left=populate(arr,i,mid);
        node.right=populate(arr,mid+1,j);
        node.val=node.left.val+node.right.val;
        return node;
    }
    public int query(int i,int j){
        return query(root,i,j);
    }
    private int query(Node root,int i,int j){
        if(root.qsi>j||root.qei<i) return 0;
        if(root.qsi>=i&&root.qei<=j) return root.val;
        return query(root.left,i,j)+query(root.right,i,j);
    }
    public void update(int i,int val){ update(root,i,val); }
    private void update(Node root,int i,int val){
        if(root.qsi>i||root.qei<i) return ;
        if(root.qsi==i&&root.qei==i) root.val=val;
        else {
            update(root.left, i, val);
            update(root.right, i, val);
            root.val = root.left.val + root.right.val;
        }
    }
    public void display(){
        display(root);
    }
    private void display(Node root){
        if(root==null) return;
        System.out.println("interval : ["+root.qsi+"-"+root.qei+"] , value: "+root.val);
        display(root.left);
        display(root.right);
    }
}
