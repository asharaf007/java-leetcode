package Java.leetcodeSolutions.medium;
import java.util.HashMap;
//Question Link Below
//https://leetcode.com/problems/copy-list-with-random-pointer/

public class CopyListWithRandomPointer {
    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map=new HashMap<>();
        Node curr=head;
        Node ans=new Node(1);
        Node temp=ans;
        while(curr!=null){
            Node  node=new Node(curr.val);
            map.put(curr,node);
            temp.next=node;
            temp=node;
            curr=curr.next;
        }
        temp=ans.next;
        curr=head;
        while(curr!=null){
            if(curr.random!=null){
                temp.random=map.get(curr.random);
            }
            curr=curr.next;
            temp=temp.next;
        }
        return ans.next;
    }
}
