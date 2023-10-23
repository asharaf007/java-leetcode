package Java.leetcodeSolution.medium;

import Java.OOPS.customDataStructures.linkedList.ListNode;

//https://leetcode.com/problems/swap-nodes-in-pairs/
public class SwapNodesInPair {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = swapPairs(head.next.next);
        ListNode ans = head.next;
        ans.next = head;
        head.next = next;
        return ans;
    }
}
