package Java.leetcodeSolution.medium;

import Java.OOPS.customDataStructures.linkedList.ListNode;

//https://leetcode.com/problems/split-linked-list-in-parts/
public class SplitLinkedList {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans=new ListNode[k];
        ListNode curr=head;
        int size=0;
        while(curr!=null){
            curr=curr.next;
            size++;
        }
        curr=head;
        int index=0;
        if(k>size){
            while(curr!=null){
                ans[index++]=curr;
                ListNode temp=curr.next;
                curr.next=null;
                curr=temp;
            }
            return ans;
        }
        int parts=size/k;
        int extra=size%k;
        int length=1;
        while(curr!=null){
            if(length==1) ans[index++]=curr;
            if(length++==parts){
                curr=extra-->0?curr.next:curr;
                head=curr.next;
                curr.next=null;
                curr=head;
                length=1;
            }
            else curr=curr.next;
        }
        return ans;
    }
}
