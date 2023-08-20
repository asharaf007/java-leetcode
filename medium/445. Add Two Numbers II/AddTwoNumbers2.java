package Java.leetcodeSolution.medium;

import Java.OOPS.customDataStructures.linkedList.ListNode;

//https://leetcode.com/problems/add-two-numbers-ii/
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        ListNode head1=l1;
        ListNode head2=l2;
        while(head1!=null){
            sb1.append((char)(head1.val+'0'));
            head1=head1.next;
        }
        while(head2!=null){
            sb1.append((char)(head2.val+'0'));
            head2=head2.next;
        }
        StringBuilder sb=sb1.length()>sb2.length()?addStrings(sb1,sb2,0):addStrings(sb2,sb1,0);
        ListNode ans=new ListNode(1);
        ListNode temp=ans;
        for(int i=0;i<sb.length();i++){
            temp.next=new ListNode(sb.charAt(i)-'0');
            temp=temp.next;
        }
        return ans.next;
    }
    private static StringBuilder addStrings(StringBuilder num1, StringBuilder num2,int carry) {
        if(num1.isEmpty()){
            StringBuilder sb=new StringBuilder();
            return carry==0?sb:sb.append("1");
        }
        if(num2.isEmpty()){
            if(carry==0) return num1;
            return addStrings(num1,new StringBuilder("1"),0);
        }
        int c=num1.charAt(num1.length()-1)+num2.charAt(num2.length()-1)+carry-96;
        carry=c/10;
        c=c%10;
        char ch=(char)(c+'0');
        return addStrings(num1.deleteCharAt(num1.length()-1),num2.deleteCharAt(num2.length()-1),carry).append(ch);
    }
}
