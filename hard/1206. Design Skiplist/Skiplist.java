package Java.leetcodeSolution.hard;

import java.util.Random;
import java.util.Stack;

//https://leetcode.com/problems/design-skiplist/
public class Skiplist {
    private class Node {
        int val;
        Node next, down;

        public Node(int val) {
            this.val = val;
        }

        void addNext(Node node) {
            node.next = this.next;
            this.next = node;
        }

        void deleteNext() {
            this.next = this.next.next;
        }
    }

    Node head;
    Random rand;

    public Skiplist() {
        head = new Node(-1);
        rand = new Random();
    }

    public boolean search(int target) {
        Node temp = head;
        while (temp != null) {
            while (temp.next != null && temp.next.val <= target) temp = temp.next;
            if (temp.val == target) return true;
            temp = temp.down;
        }
        return false;
    }

    public void add(int num) {
        Stack<Node> st = new Stack<>();
        Node temp = head;
        while (temp != null) {
            while (temp.next != null && temp.next.val <= num) temp = temp.next;
            st.push(temp);
            temp = temp.down;
        }
        boolean flipCoin = true;
        while (!st.isEmpty() && flipCoin) {
            Node curr = new Node(num);
            Node pop = st.pop();
            pop.addNext(curr);
            if (pop.val == num) return;
            curr.down = temp;
            temp = curr;
            flipCoin = rand.nextBoolean();
        }
        if (flipCoin) {
            Node dummy = new Node(-1);
            dummy.down = head;
            dummy.addNext(new Node(num));
            dummy.next.down = temp;
            head = dummy;
        }
    }

    public boolean erase(int num) {
        Node temp = head;
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
