package Java.leetcodeSolution.medium;

import Java.OOPS.customDataStructures.linkedList.ListNode;
//Question Link Below
//https://leetcode.com/problems/sort-list/

public class SortList {
    //mergeSorting using recursion
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode mid=middleNode(head);
        ListNode right=sortList(mid.next);
        ListNode left=sortList(head);
        return mergeTwoLists(right,left);
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans=new ListNode(1);
        ListNode curr=ans;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                curr.next=list1;
                curr=list1;
                list1=list1.next;
            }
            else{
                curr.next=list2;
                curr=list2;
                list2=list2.next;
            }
        }
        while(list1!=null){
            curr.next=list1;
            curr=list1;
            list1=list1.next;
        }
        while(list2!=null){
            curr.next=list2;
            curr=list2;
            list2=list2.next;
        }
        return ans.next;
    }
    private ListNode middleNode(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
