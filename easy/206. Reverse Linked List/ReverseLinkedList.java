package Java.leetcodeSolutions.easy;

import Java.OOPS.linkedList.ListNode;
//Question Link Below
//https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList {
    //recursion
    public ListNode reverseListRecursion(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode node=reverseListRecursion(head.next);
        ListNode temp=node;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=head;
        head.next=null;
        return node;
    }
    public ListNode reverseList(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode ahead=head.next;
        head.next=null;
        while(ahead!=null){
            ListNode temp=ahead.next;
            ahead.next = head;
            head=ahead;
            ahead=temp;
        }
        return head;
    }
}
