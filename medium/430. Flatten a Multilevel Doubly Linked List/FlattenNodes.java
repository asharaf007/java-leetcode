package Java.leetcodeSolution.medium;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
public class FlattenNodes {
    private class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    public Node flatten(Node head) {
        Deque<Node> stack=new ArrayDeque<>();
        Node curr=head;
        while(!stack.isEmpty()||curr.next!=null||curr.child!=null){
            if(curr.child!=null){
                stack.push(curr.next);
                curr.next=curr.child;
                curr.next.prev=curr;
                curr.child=null;
            }
            else if(curr.next==null){
                curr.next=stack.pop();
                curr.next.prev=curr;
            }
            curr=curr.next;
        }
        return head;
    }
}
