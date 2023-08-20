package Java.leetcodeSolutions.easy;

import Java.OOPS.customDataStructures.linkedList.ListNode;
//Question Link Below
//https://leetcode.com/problems/middle-of-the-linked-list/
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
