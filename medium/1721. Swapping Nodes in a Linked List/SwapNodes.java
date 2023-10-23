package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

import Java.OOPS.customDataStructures.linkedList.ListNode;

public class SwapNodes {
    public ListNode swapNodes(ListNode head, int k) {
        int size = getSize(head);
        if (k == size - k + 1) {
            return head;
        }
        ListNode prev1 = k < size - k + 1 ? getNode(head, k - 1) : getNode(head, size - k);
        ListNode prev2 = k < size - k + 1 ? getNode(head, size - k) : getNode(head, k - 1);
        ListNode curr1 = prev1 == null ? head : prev1.next;
        ListNode curr2 = prev2 == null ? head : prev2.next;
        if (prev1 != null) prev1.next = curr2;
        if (curr1 == prev2) {
            curr1.next = curr2.next;
            curr2.next = curr1;
        } else {
            ListNode temp = curr1.next;
            curr1.next = curr2.next;
            prev2.next = curr1;
            curr2.next = temp;
        }
        if (curr1 == head) {
            head = curr2;
        }
        return head;
    }

    private int getSize(ListNode head) {
        ListNode temp = head;
        int ans = 0;
        while (temp != null) {
            ans++;
            temp = temp.next;
        }
        return ans;
    }

    private ListNode getNode(ListNode head, int k) {
        if (k == 0) return null;
        ListNode temp = head;
        while (k-- > 1) {
            temp = temp.next;
        }
        return temp;
    }

}
