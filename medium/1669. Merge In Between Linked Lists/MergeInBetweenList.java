package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/merge-in-between-linked-lists/

import Java.OOPS.customDataStructures.linkedList.ListNode;

public class MergeInBetweenList {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode right=list1;
        ListNode left=list1;
        int count=0;
        while(count++<=b){
            if(count==a) left=right;
            right=right.next;
        }
        left.next=list2;
        while(list2.next!=null){
            list2=list2.next;
        }
        list2.next=right;
        return list1;
    }
}
