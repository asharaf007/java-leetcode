package Java.leetcodeSolutions.medium;

import Java.OOPS.linkedList.CustomLinkedList;
import Java.OOPS.linkedList.ListNode;
//Question Link Below
//https://leetcode.com/problems/delete-node-in-a-linked-list/
public class DeleteNodeInALinkedList {
    public static void main(String[] args) {
        CustomLinkedList list =new CustomLinkedList();
        list.addTail(4);
        list.addTail(5);
        list.addTail(1);
        list.addTail(9);
        deleteNode(list.head.next);
        list.display(list.head);
    }
    public static void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
