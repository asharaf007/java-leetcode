package Java.leetcodeSolution.medium;

import Java.OOPS.customDataStructures.linkedList.ListNode;

//https://leetcode.com/problems/partition-list/
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode tailLeft = null;
        ListNode headRight = head;
        while (headRight != null && headRight.val < x) {
            tailLeft = headRight;
            headRight = headRight.next;
        }
        if (headRight == null) return head;
        ListNode headMiddle = new ListNode(0);
        ListNode tailMiddle = headMiddle;
        ListNode curr = headRight;
        ListNode next = headRight.next;
        while (curr != null && next != null) {
            while (next != null && next.val < x) {
                tailMiddle.next = next;
                tailMiddle = tailMiddle.next;
                next = next.next;
            }
            curr.next = next;
            curr = curr.next;
            if (next != null) next = next.next;
        }
        tailMiddle.next = headRight;
        if (tailLeft != null) {
            tailLeft.next = headMiddle.next;
            return head;
        }
        return headMiddle.next;
    }
}
