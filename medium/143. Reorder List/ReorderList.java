package Java.leetcodeSolution.medium;

import Java.OOPS.customDataStructures.linkedList.ListNode;

//https://leetcode.com/problems/reorder-list/
public class ReorderList {
    public void reorderList(ListNode head) {
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
    private ListNode middleNode(ListNode head) {
            ListNode fast=head;
            ListNode slow=head;
            while(fast!=null&&fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }
            return slow;
        }
    private ListNode reverseList(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode node=head;
        ListNode ahead=node.next;
        node.next=null;
        while(ahead!=null){
            ListNode temp=ahead.next;
            ahead.next = temp;
            temp=ahead;
            ahead=temp;
        }
        head=ahead;
        return head;
    }

}
