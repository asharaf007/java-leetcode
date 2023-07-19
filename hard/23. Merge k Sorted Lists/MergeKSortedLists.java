package Java.leetcodeSolutions.hard;

import Java.OOPS.linkedList.ListNode;

//Question Link Below
//https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        if(lists.length==1){
            return lists[0];
        }
        int stIndex=0;
        int endIndex=lists.length-1;
        return mergeKSortedLists(lists,stIndex,endIndex);
    }
    public ListNode mergeKSortedLists(ListNode[] lists,int stIndex,int endIndex){
        if(stIndex==endIndex){
            return lists[stIndex];
        }
        int midIndex=stIndex+(endIndex-stIndex)/2;
        ListNode left=mergeKSortedLists(lists,stIndex,midIndex);
        ListNode right=mergeKSortedLists(lists,midIndex+1,endIndex);
        return mergeTwoLists(left,right);
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
}
