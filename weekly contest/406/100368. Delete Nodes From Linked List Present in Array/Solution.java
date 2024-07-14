//https://leetcode.com/contest/weekly-contest-406/problems/delete-nodes-from-linked-list-present-in-array/submissions/1320339549/
public class Solution {

    public ListNode modifiedList(int[] nums, ListNode head) {
        boolean[] done = new boolean[100001];
        for (int num : nums) {
            done[num] = true;
        }
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            if (done[temp.val]) {
                if (prev == null) {
                    head = temp.next;
                } else {
                    prev.next = temp.next;
                }
            } else {
                prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }
}
