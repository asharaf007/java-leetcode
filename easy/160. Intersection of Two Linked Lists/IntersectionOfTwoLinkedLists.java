package Java.leetcodeSolutions.easy;

import Java.OOPS.customDataStructures.linkedList.CustomLinkedList;
import Java.OOPS.customDataStructures.linkedList.ListNode;
//Question Link Below
//https://leetcode.com/problems/intersection-of-two-linked-lists/

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        CustomLinkedList list1=new CustomLinkedList();
        CustomLinkedList list2=new CustomLinkedList();
        list1.addTail(4);
        list1.addTail(1);
        list1.addTail(8);
        list2.addTail(5);
        list2.addTail(6);
        list2.addTail(1);
        list2.tail.next=list1.tail;
        list2.tail=list1.tail;
        list1.addTail(4);
        list1.addTail(5);
        System.out.println(getIntersectionnode(list1.head,list2.head).val);
        list1.display(list1.head);
        list2.display(list2.head);
    }
    public static ListNode getIntersectionnode(ListNode headA, ListNode headB) {
        ListNode ptrA = headA, ptrB = headB;
        while (ptrA != ptrB) { // loop until we found the first common node
            ptrA = ptrA == null ? headB : ptrA.next; // once we're done with A, move to B
            ptrB = ptrB == null ? headA : ptrB.next; // once we're done with B, move to A
        }
        return ptrA;
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==headB){
            return headA;
        }
        //add both lists
        ListNode temp=headA;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=headB;
        ListNode ans=detectCycle(headA);
        temp.next=null;
        return ans;
    }
    private static ListNode detectCycle(ListNode head) {
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
