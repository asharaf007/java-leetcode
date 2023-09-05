package Java.leetcodeSolutions.medium;

import Java.OOPS.customDataStructures.linkedList.ListNode;
//Question Link Below
//https://leetcode.com/problems/linked-list-cycle-ii/
public class LinkedListCycle2 {
    public static ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head.next==head?head:null;
        }
        ListNode fast=head.next.next;
        ListNode slow=head.next;
        while(fast!=null&&fast.next!=null){
            if(fast==slow){
                //find length of the cycle
                int length=lengthCycle(fast,slow);
                //return head of the cycle
                return headCycle(head,length);
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        //out of loop,it must have hit null means no cycle in list so
        // return null
        return null;
    }
    private static int lengthCycle(ListNode fast,ListNode slow){
        int length=0;
        do{
            fast=fast.next.next;
            slow=slow.next;
            length++;
        }while(fast!=slow);
        return length;
    }
    private static ListNode headCycle(ListNode head,int length){
        ListNode first=head;
        ListNode second=head;
        while(length!=0){
            second=second.next;
            length--;
        }
        while(first!=second){
            first=first.next;
            second=second.next;
        }
        return first;
    }
}
