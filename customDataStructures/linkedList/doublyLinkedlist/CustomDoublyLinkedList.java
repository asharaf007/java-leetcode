package Java.OOPS.customDataStructures.linkedList;

public class CustomDoublyLinkedList {
    //IMPLEMENTATION BELOW
    int size;
    Node head;
    Node tail;

    public class Node {
        private int value;
        private Node next;
        private Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    CustomDoublyLinkedList() {
    }

    CustomDoublyLinkedList(int value) {
        Node node = new Node(value);
        head = node;
        tail = node;
        size = 1;
    }

    public void addHead(int value) {
        Node node = new Node(value);
        node.next = head;
        if (head != null) {
            head.prev = node;
        } else {
            tail = node;
        }
        head = node;
        size++;
    }

    public void addTail(int value) {
        Node node = new Node(value);
        if (tail != null) {
            tail.next = node;
        } else {
            head = node;
        }
        node.prev = tail;
        tail = node;
        size++;
    }

    public void insert(int value, int index) {
        if (index == 0) {
            addHead(value);
            return;
        }
        if (index == size - 1) {
            addTail(value);
            return;
        }
        Node node = new Node(value);
        Node temp = head;
        while (index != 1) {
            temp = temp.next;
            index--;
        }
        node.next = temp.next;
        temp.next.prev = node;
        node.prev = temp;
        temp.next = node;
        size++;
    }

    public void display() {
        System.out.print("null -> ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("null");

        temp = tail;
        System.out.print("null -> ");
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    public int removeHead() {
        int val = head.value;
        if (head != null) {
            head = head.next;
            head.prev = null;
        }
        size--;
        return val;
    }

    public int removeTail() {
        int val = tail.value;
        if (tail != null) {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return val;
    }

    public int remove(int index) {
        if (index == 0) {
            return removeHead();
        }
        if (index == size - 1) {
            return removeTail();
        }
        Node temp = head;
        while (index != 1) {
            temp = temp.next;
            index--;
        }
        int val = temp.next.value;
        temp.next = temp.next.next;
        temp.next.prev = temp;
        size--;
        return val;
    }
}
