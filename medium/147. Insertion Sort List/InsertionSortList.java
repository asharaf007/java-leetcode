package Java.leetcodeSolution.medium;

import Java.OOPS.customDataStructures.linkedList.ListNode;

//https://leetcode.com/problems/insertion-sort-list/
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=insertionSortList(head.next);
        ListNode curr=dummy;
        while(curr.next!=null&&curr.next.val<head.val) curr=curr.next;
        head.next=curr.next;
        curr.next=head;
        return dummy.next;
    }
}
