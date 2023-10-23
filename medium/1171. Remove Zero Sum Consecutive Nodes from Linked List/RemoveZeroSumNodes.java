package Java.leetcodeSolution.medium;

import Java.OOPS.customDataStructures.linkedList.ListNode;

import java.util.HashMap;

//https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
public class RemoveZeroSumNodes {
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode curr = ans;
        int sum = 0;
        while (curr != null) {
            sum += curr.val;
            if (map.containsKey(sum)) {
                ListNode temp = map.get(sum);
                ListNode next = temp.next;
                int tempSum = sum;
                while (next != curr) {
                    tempSum += next.val;
                    map.remove(tempSum);
                    next = next.next;
                }
                temp.next = next.next;
            } else map.put(sum, curr);
            curr = curr.next;
        }
        return ans.next;
    }
}
