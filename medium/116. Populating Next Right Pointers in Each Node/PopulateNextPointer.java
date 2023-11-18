package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
import java.util.*;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
public class PopulateNextPointer {
    public Node connect(Node root) {
        if(root==null) return root;
        Node leftMost=root;
        while(leftMost.left!=null){
            Node curr=leftMost;
            while(true){
                curr.left.next=curr.right;
                if(curr.next==null) break;
                curr.right.next=curr.next.left;
                curr=curr.next;
            }
            leftMost=leftMost.left;
        }
        return root;
    }
}
