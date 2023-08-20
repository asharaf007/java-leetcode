package Java.leetcodeSolution.easy;

import Java.OOPS.customDataStructures.linkedList.ListNode;
//https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
public class DecimalNumberFromBinary {
    public int getDecimalValue(ListNode head) {
        StringBuilder binary=new StringBuilder();
        ListNode temp=head;
        while(temp!=null){
            binary.append(temp.val+'0');
            temp=temp.next;
        }
        int factor=1;
        int ans=0;
        for(int i=binary.length()-1;i>=0;i++){
            if(binary.charAt(i)=='1') ans+=factor;
            factor*=2;
        }
        return ans;
    }
}
