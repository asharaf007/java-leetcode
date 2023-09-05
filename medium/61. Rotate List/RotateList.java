package Java.leetcodeSolution.medium;
import Java.OOPS.customDataStructures.linkedList.CustomLinkedList;
import Java.OOPS.customDataStructures.linkedList.ListNode;
//Question Link Below
//https://leetcode.com/problems/rotate-list/
public class RotateList {
    public static void main(String[] args) {
        CustomLinkedList list=new CustomLinkedList();
        list.addTail(1);
        list.addTail(2);
        list.addTail(3);
        list.addTail(4);
        list.addTail(5);
        list.display(rotateRight(list.head,7));
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        //get size and tail
        int size=1;
        ListNode curr=head;
        while(curr.next!=null){
            size++;
            curr=curr.next;
        }
        k%=size;
        if(k==0){
            return head;
        }
        curr.next=head;
        while(size-k++>0){
            curr=curr.next;
        }
        head=curr.next;
        curr.next=null;
        return head;
    }
}
