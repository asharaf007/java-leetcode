package Java.leetcodeSolution.easy;

import Java.OOPS.customDataStructures.linkedList.ListNode;
//Question Link Below
//https://leetcode.com/problems/palindrome-linked-list/
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode temp=head;
        ListNode mid=middleNode(temp);
        ListNode headReverse=reverseList(mid);
        ListNode reReverseHead=headReverse;
        while(headReverse!=null){
            if(temp.val!=headReverse.val){
                break;
            }
            temp=temp.next;
            headReverse=headReverse.next;
        }
        reverseList(reReverseHead);
        return headReverse==null;
    }
    public ListNode middleNode(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp=head;
        ListNode ahead = temp.next;
        temp.next = null;
        while (ahead != null) {
            ListNode node = ahead.next;
            ahead.next = temp;
            temp = ahead;
            ahead = node;
        }
        return temp;
    }
}
