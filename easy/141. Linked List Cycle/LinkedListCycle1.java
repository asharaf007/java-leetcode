package Java.leetcodeSolutions.easy;

import Java.OOPS.linkedList.ListNode;
//Question Link Below
//https://leetcode.com/problems/linked-list-cycle/

public class LinkedListCycle1 {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        if(head.next==null){
            return head.next==head;
        }
        ListNode fast=head.next.next;
        ListNode slow=head.next;
        while(fast!=null&&fast.next!=null){
            if(fast==slow){
                return true;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        return false;
    }
}
