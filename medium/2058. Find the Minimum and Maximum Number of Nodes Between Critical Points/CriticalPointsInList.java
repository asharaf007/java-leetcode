package Java.leetcodeSolution.medium;

import Java.OOPS.customDataStructures.linkedList.CustomLinkedList;
import Java.OOPS.customDataStructures.linkedList.ListNode;

import java.util.*;

//https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
public class CriticalPointsInList extends CustomLinkedList {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.addTail(5);
        list.addTail(3);
        list.addTail(1);
        list.addTail(2);
        list.addTail(5);
        list.addTail(1);
        list.addTail(2);
        int[] ans = nodesBetweenCriticalPoints(list.head);
        for (int i = 0; i < ans.length; i++) System.out.println(ans[i]);
    }

    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> points = new ArrayList<>();
        ListNode curr = head;
        int pos = 2;
        while (curr.next.next != null) {
            int val1 = curr.val;
            int val2 = curr.next.val;
            int val3 = curr.next.next.val;
            if ((val2 > val1 && val2 > val3) || (val2 < val1 && val2 < val3)) points.add(pos);
            curr = curr.next;
            pos++;
        }
        int size = points.size();
        if (size <= 1) return new int[]{-1, -1};
        int min = 1000000;
        for (int i = 0; i < size - 1; i++) {
            min = Math.min(min, points.get(i + 1) - points.get(i));
        }
        return new int[]{min, points.get(size - 1) - points.get(0)};
    }
}
