package Java.OOPS.customDataStructures.linkedList;

import java.util.Random;
import java.util.Stack;

//insertion,deletion,searching in O(log n) time with high probability
public class CustomSkipList {
    //IMPLEMENTATION BELOW
    private class ListNode {
        int val;
        ListNode next, down;

        public ListNode(int val) {
            this.val = val;
        }

        void addNext(ListNode ListNode) {
            ListNode.next = this.next;
            this.next = ListNode;
        }

        void deleteNext() {
            this.next = this.next.next;
        }
    }

    ListNode head;
    Random rand;

    public CustomSkipList() {
        head = new ListNode(-1);
        rand = new Random();
    }

    public boolean search(int target) {
        ListNode temp = head;
        while (temp != null) {
            while (temp.next != null && temp.next.val <= target) temp = temp.next;
            if (temp.val == target) return true;
            temp = temp.down;
        }
        return false;
    }

    public void add(int num) {
        Stack<ListNode> st = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            while (temp.next != null && temp.next.val <= num) temp = temp.next;
            st.push(temp);
            temp = temp.down;
        }
        boolean flipCoin = true;
        while (!st.isEmpty() && flipCoin) {
            ListNode curr = new ListNode(num);
            ListNode pop = st.pop();
            pop.addNext(curr);
            if (pop.val == num) return;
            curr.down = temp;
            temp = curr;
            flipCoin = rand.nextBoolean();
        }
        if (flipCoin) {
            ListNode dummy = new ListNode(-1);
            dummy.down = head;
            dummy.addNext(new ListNode(num));
            dummy.next.down = temp;
            head = dummy;
        }
    }

    public boolean erase(int num) {
        ListNode temp = head;
        boolean found = false;
        while (temp != null) {
            while (temp.next != null && temp.next.next != null && temp.next.val < num) temp = temp.next;
            if (temp.next != null && temp.next.val == num) {
                if (!found) found = true;
                temp.deleteNext();
            }
            temp = temp.down;
        }
        return found;
    }
}
