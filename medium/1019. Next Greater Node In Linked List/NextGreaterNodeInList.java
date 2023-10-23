package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/next-greater-node-in-linked-list/

import Java.OOPS.customDataStructures.linkedList.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class NextGreaterNodeInList {
    public int[] nextLargerNodes(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        HashMap<ListNode, Integer> map = new HashMap<>();
        ListNode curr = head;
        int size = 1;
        while (curr.next != null) {
            if (curr.val >= curr.next.val) stack.push(curr);
            else {
                int value = curr.next.val;
                map.put(curr, value);
                while (!stack.isEmpty() && stack.peek().val < value) {
                    map.put(stack.pop(), value);
                }
            }
            curr = curr.next;
            size++;
        }
        int[] ans = new int[size];
        int i = 0;
        curr = head;
        while (i < size) {
            ans[i++] = map.getOrDefault(curr, 0);
            curr = curr.next;
        }
        return ans;
    }
}
