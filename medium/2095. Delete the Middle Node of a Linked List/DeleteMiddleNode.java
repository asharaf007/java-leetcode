package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
import Java.OOPS.customDataStructures.linkedList.ListNode;
public class DeleteMiddleNode {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null) return null;
        ListNode slow=head;
        ListNode fast=head.next.next;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}
