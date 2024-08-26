//https://leetcode.com/problems/add-two-numbers-ii/
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=reverseList(l1);
        l2=reverseList(l2);
        ListNode head=new ListNode(0);
        ListNode temp=head;
        int carry=0;
        while(l1!=null||l2!=null){
            if(l1==null){
                carry+=l2.val;
            }else if(l2==null){
                carry+=l1.val;
            }else{
                carry+=l1.val+l2.val;
            }
            temp.next=new ListNode(carry%10);
            carry/=10;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
            temp=temp.next;
        }
        if(carry>0){
            temp.next=new ListNode(carry);
        }
        return reverseList(head.next);
    }
    private ListNode reverseList(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode next=head.next;
        ListNode newHead=reverseList(next);
        next.next=head;
        head.next=null;
        return newHead;
    }
}
