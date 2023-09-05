package Java.leetcodeSolution.medium;

import Java.OOPS.customDataStructures.linkedList.ListNode;
//Question Link Below
//https://leetcode.com/problems/reverse-linked-list-ii/
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next==null||right==left){
            return head;
        }
        int count=left;
        ListNode curr=head;
        while(count>2){
            curr=curr.next;
            count--;
        }
        ListNode last=curr;
        curr=curr.next;
        ListNode newEnd=curr;
        if(left==1){
            newEnd=head;
            last=null;
            curr=head;
        }
        ListNode next=curr.next;
        while(right!=left){
            ListNode node=next.next;
            next.next=curr;
            curr=next;
            next=node;
            left++;
        }
        newEnd.next=next;
        if(last==null){
            return curr;
        }
        last.next=curr;
        return head;
    }
}
