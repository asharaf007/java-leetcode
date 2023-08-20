package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/add-two-numbers/
import Java.OOPS.customDataStructures.linkedList.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1=l1;
        ListNode temp2=l2;
        ListNode ans=new ListNode(1);
        ListNode curr=ans;
        int carry=0;
        while(temp1!=null&&temp2!=null){
            int digit=temp1.val+temp2.val+carry;
            temp1=temp1.next;
            temp2=temp2.next;
            curr.next=new ListNode(digit%10);
            curr=curr.next;
            carry=digit/10;
        }
        while(temp1!=null){
            int digit=temp1.val+carry;
            curr.next=new ListNode(digit%10);
            curr=curr.next;
            temp1=temp1.next;
            carry=digit/10;
        }
        while(temp2!=null){
            int digit=temp2.val+carry;
            curr.next=new ListNode(digit%10);
            curr=curr.next;
            temp2=temp2.next;
            carry=digit/10;
        }
        ListNode res=ans.next;
        if(carry!=0){
            curr.next=ans;
            ans.next=null;
        }
        return res;
    }
}
