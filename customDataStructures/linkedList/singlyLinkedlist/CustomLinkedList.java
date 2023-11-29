package Java.OOPS.customDataStructures.linkedList;

import Java.OOPS.customDataStructures.linkedList.ListNode;

public class CustomLinkedList {
    //IMPLEMENTATION BELOW

    public ListNode head;
    public ListNode tail;

    public CustomLinkedList() {
    }

    CustomLinkedList(int value) {
        ListNode node = new ListNode(value);
        head = node;
        tail = node;
    }

    public void addHead(int value) {
        ListNode temp = new ListNode(value);
        if (head == null) {
            tail = temp;
        } else {
            temp.next = head;
        }
        head = temp;
    }

    public void addTail(int value) {
        ListNode temp = new ListNode(value);
        if (head == null) {
            head = temp;
        } else {
            tail.next = temp;
        }
        tail = temp;
    }

    public int removeHead() {
        int temp = head.val;
        head = head.next;
        return temp;
    }

    public int removeTail() {
        ListNode temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        int val = temp.next.val;
        temp.next = null;
        tail = temp;
        return val;
    }

    public void insert(int value, int index) {
        ListNode temp = head;
        while (index != 1) {
            temp = temp.next;
            index--;
        }
        ListNode node = new ListNode(value);
        node.next = temp.next;
        temp.next = node;
    }

    public int remove(int index) {
        ListNode temp = head;
        while (index != 1) {
            temp = temp.next;
            index--;
        }
        int val = temp.next.val;
        temp.next = temp.next.next;
        return val;
    }

    public void display(ListNode node) {
        ListNode temp = node;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //////////////////////////////////////////////////////////////////////////////
    public int lengthCycle(ListNode head) {
        if (head == null) {
            return 0;
        }
        if (head.next == null) {
            return head.next == head ? 1 : 0;
        }
        boolean bool = false;
        int length = 0;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast.next != null) {
            if (bool == true && fast != slow) {
                length++;
            }
            if (fast == slow && bool == false) {
                bool = true;
                length = 1;
            }
            if (fast == slow && bool == true) {
                return length;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return length;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head;
        ListNode ahead = node.next;
        node.next = null;
        while (ahead != null) {
            ListNode temp = ahead.next;
            ahead.next = temp;
            temp = ahead;
            ahead = temp;
        }
        head = ahead;
        return head;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null || right == left) {
            return head;
        }
        int count = left;
        ListNode temp = head;
        while (count > 2) {
            temp = temp.next;
            count--;
        }
        ListNode last = temp;
        temp = temp.next;
        ListNode newEnd = temp;
        if (left == 1) {
            newEnd = head;
            last = null;
        }
        ListNode ahead = temp.next;
        while (right != left) {
            ListNode node = ahead.next;
            ahead.next = temp;
            temp = ahead;
            ahead = node;
            left++;
        }
        newEnd.next = ahead;
        if (last == null) {
            return temp;
        }
        last.next = temp;
        return head;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        ListNode mid = middleNode(temp);
        ListNode headReverse = reverseList(mid);
        ListNode reReverseHead = headReverse;
        while (headReverse != null) {
            if (temp.val != headReverse.val) {
                break;
            }
            temp = temp.next;
            headReverse = headReverse.next;
        }
        return headReverse == null;
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode temp = head;
        ListNode secondHead = reverseList(mid);
        while (temp != null && secondHead != null) {
            ListNode node = temp.next;
            if (node == null) {
                break;
            }
            temp.next = secondHead;
            temp = node;
            node = secondHead.next;
            if (node == null) {
                break;
            }
            secondHead.next = temp;
            secondHead = node;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return reverseKNodes(head, size, k);
    }

    public ListNode reverseKNodes(ListNode head, int size, int k) {
        if (k < size) {
            return head;
        }
        int count = k;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while (count > 0) {
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = reverseKNodes(curr, size - k, k);
        return prev;
    }

    public void removeItem(int val) {
        ListNode temp = head;
        ListNode next = head.next;
        while (next != null) {
            if (next.val == val) {
                temp.next = next.next;
                break;
            }
            temp = temp.next;
            next = next.next;
        }
    }
}

