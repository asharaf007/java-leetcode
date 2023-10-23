package Java.leetcodeSolution.medium;

import Java.OOPS.customDataStructures.linkedList.ListNode;

//Question Link Below
//https://leetcode.com/problems/odd-even-linked-list/
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode secondHead = head.next;
        ListNode a = head;
        ListNode b = head.next;
        ListNode next = head.next.next;
        while (a != null && b != null && next != null) {
            a.next = next;
            a = next;
            b.next = a.next;
            b = a.next;
            if (b != null) {
                next = b.next;
            }
        }
        if (b != null) {
            b.next = null;
        }
        a.next = secondHead;
        return head;
    }
}
