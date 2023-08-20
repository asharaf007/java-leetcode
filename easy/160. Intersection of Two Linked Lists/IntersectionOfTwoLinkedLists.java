package Java.leetcodeSolutions.easy;

import Java.OOPS.customDataStructures.linkedList.CustomLinkedList;
import Java.OOPS.customDataStructures.linkedList.ListNode;
import static Java.leetcodeSolutions.medium.LinkedListCycle2.detectCycle;
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
}
