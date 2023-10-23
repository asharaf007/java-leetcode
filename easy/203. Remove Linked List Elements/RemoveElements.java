package Java.leetcodeSolution.easy;

import Java.OOPS.customDataStructures.linkedList.ListNode;

//https://leetcode.com/problems/remove-linked-list-elements/
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        //iterative way
        /*
        while(head!=null&&head.val==val){
            head=head.next;
        }
        ListNode temp=head;
        ListNode next=temp.next;
        while(next!=null){
            if(next.val==val){
                temp.next=next.next;
                next=temp.next;
            }
            else{
                temp=temp.next;
                next=next.next;
            }
        }
        return head;
         */
        //recursive way
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return removeElements(head.next, val);
        }
        head.next = removeElements(head.next, val);
        return head;
    }
}
