package Java.leetcodeSolutions.hard;
import Java.OOPS.linkedList.CustomLinkedList;
import Java.OOPS.linkedList.ListNode;
//Question Link Below
//https://leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseNodesInKgroup {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.addTail(1);
        list.addTail(2);
        list.addTail(3);
        list.addTail(4);
        list.addTail(5);
        list.addTail(6);
        list.addTail(7);
        list.addTail(8);
        list.addTail(9);
        System.out.println(list.head.val);
        list.display(reverseKgroup(list.head, 2));
    }
    //without recursion space complexity: O(1)
    public static ListNode reverseKgroup(ListNode head,int k){
        if(k==1||head==null){
            return head;
        }
        int size=getSize(head);
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=head.next;
        ListNode last=null;
        while(curr!=null&&size>=k){
            ListNode newLast=curr;
            for (int i = 0; i < k; i++,size--) {
                curr.next=prev;
                prev=curr;
                curr=next;
                if(next!=null) {
                    next = next.next;
                }
            }
            newLast.next=curr;
            if(last!=null){
                last.next=prev;
            }else{
                head=prev;
            }
            last=newLast;
        }
        return head;
    }

    public static int getSize(ListNode head) {
        ListNode temp=head;
        int size=0;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        return size;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        return reverseKNodes(head,getSize(head),k);
    }
    //using recursion spavce complexity:O(n/k)
    public static ListNode reverseKNodes(ListNode head, int size, int k){
        if(size<k){
            return head;
        }
        int count=k;
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=head.next;
        while(count>0&&curr!=null){
            curr.next=prev;
            prev=curr;
            curr=next;
            if(next!=null) {
                next = next.next;
            }
            count--;
        }
        head.next=reverseKNodes(curr,size-k,k);
        return prev;
    }

}
