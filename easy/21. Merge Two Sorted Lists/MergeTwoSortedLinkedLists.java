package Java.leetcodeSolution.easy;
//https://leetcode.com/problems/merge-two-sorted-lists/
import Java.OOPS.customDataStructures.linkedList.ListNode;

public class MergeTwoSortedLinkedLists {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode ans=new ListNode(1);
            ListNode curr=ans;
            ListNode temp1=list1;
            ListNode temp2=list2;
            while(temp1!=null&&temp2!=null){
                if(temp1.val<temp2.val){
                    ListNode temp=new ListNode(temp1.val);
                    curr.next=temp;
                    curr=curr.next;
                    temp1=temp1.next;
                }
                else{
                    ListNode temp=new ListNode(temp2.val);
                    curr.next=temp;
                    curr=curr.next;
                    temp2=temp2.next;
                }
            }
            while(temp1!=null){
                curr.next=temp1;
                curr=curr.next;
                temp1=temp1.next;
            }
            while(temp2!=null){
                curr.next=temp2;
                curr=curr.next;
                temp2=temp2.next;
            }
            return ans.next;
        }
}
