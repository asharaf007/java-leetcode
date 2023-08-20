package Java.leetcodeSolutions.medium;

import Java.OOPS.customDataStructures.linkedList.ListNode;

import static Java.OOPS.customDataStructures.linkedList.CustomLinkedList.reverseList;
//Question Link Below
//https://leetcode.com/problems/reorder-list/
public class ReorderList {
    public static void reorderList(ListNode head) {
        if(head==null||head.next==null){
            return;
        }
        ListNode mid=middleNode(head);
        ListNode temp=head;
        ListNode secondHead=reverseList(mid);
        while(temp!=null&&secondHead!=null){
            ListNode node=temp.next;
            if(node==null){
                break;
            }
            temp.next=secondHead;
            temp=node;
            node=secondHead.next;
            if(node==null){
                break;
            }
            secondHead.next=temp;
            secondHead=node;
        }
    }
        public static ListNode middleNode(ListNode head) {
            ListNode fast=head;
            ListNode slow=head;
            while(fast!=null&&fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }
            return slow;
        }

}
