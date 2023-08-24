package Java.leetcodeSolution.medium;

import Java.OOPS.customDataStructures.linkedList.ListNode;

import java.util.Random;

//https://leetcode.com/problems/linked-list-random-node/
public class GetRandomNode {
    private Random rand;
    private ListNode head;
    private int size;
    public GetRandomNode(ListNode head) {
        this.head=head;
        while(head!=null){
            size++;
            head=head.next;
        }
        rand=new Random();
    }

    public int getRandom() {
        int count=rand.nextInt(size);
        ListNode curr=head;
        while(count-->0) curr=curr.next;
        return curr.val;
    }
}
