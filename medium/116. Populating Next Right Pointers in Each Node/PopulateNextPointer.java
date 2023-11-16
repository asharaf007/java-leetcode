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
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        int size=q.size();
        while(!q.isEmpty()) {
            Node node=q.poll();
            if(node.left!=null) q.add(node.left);
            if(node.right!=null) q.add(node.right);
            if(--size>0)node.next=q.peek();
            else size=q.size();
        }
        return root;
    }
}
