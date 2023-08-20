package Java.leetcodeSolution.medium;

import Java.OOPS.customDataStructures.linkedList.ListNode;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
public class RemoveDuplicateInList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        boolean bool=false;
        while(head.next!=null&&head.val==head.next.val) {
            head=head.next;
            if(bool==false) bool=true;
        }
        if(bool) return deleteDuplicates(head.next);
        head.next=deleteDuplicates(head.next);
        return head;
    }
}
