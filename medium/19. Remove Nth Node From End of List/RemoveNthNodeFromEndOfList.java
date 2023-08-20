package Java.leetcodeSolutions.medium;
import Java.OOPS.customDataStructures.linkedList.ListNode;
//Question Link Below
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        for(int i=0;i<n;i++){
            temp=temp.next;
        }
        if(temp==null){
            return head.next;
        }
        ListNode delay=head;
        while(temp.next!=null){
            temp=temp.next;
            delay=delay.next;
        }
        delay.next=delay.next.next;
        return head;
    }
}
