package Java.leetcodeSolution.medium;

import Java.OOPS.customDataStructures.linkedList.ListNode;

//https://leetcode.com/problems/reverse-nodes-in-even-length-groups/
public class ReverseNodesInEvenLengthGroup {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        return solve(head, size, 1);
    }

    private ListNode solve(ListNode head, int size, int group) {
        if (size <= group) return size % 2 == 1 ? head : reverseList(head);
        ListNode tail = head;
        int count = 1;
        while (count++ < group) tail = tail.next;
        if (group % 2 == 0) {
            ListNode tailNext = tail.next;
            tail.next = null;
            reverseList(head);
            head.next = solve(tailNext, size - group, group + 1);
            return tail;
        }
        tail.next = solve(tail.next, size - group, group + 1);
        return head;
    }

    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head;
        ListNode ahead = node.next;
        node.next = null;
        while (ahead != null) {
            ListNode temp = ahead.next;
            ahead.next = node;
            node = ahead;
            ahead = temp;
        }
        head = node;
        return head;
    }
}
