package Java.leetcodeSolution.medium;

import java.util.HashMap;

//Question Link below
//https://leetcode.com/problems/lru-cache/
public class LRUCache {
    public static void main(String[] args) {
        LRUCache l = new LRUCache(2);
        l.put(1, 1);
        l.put(2, 2);
        l.put(3, 3);
        System.out.println(l.get(1));
        System.out.println(l.get(2));
        System.out.println(l.get(3));
    }

    public class ListNode {
        private int key;
        private int value;
        private ListNode next;
        private ListNode prev;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    public class DLL {
        ListNode head;
        ListNode tail;

        DLL() {
            head = new ListNode(0, 0);
            tail = new ListNode(0, 0);
            head.next = tail;
            tail.next = null;
            head.prev = null;
            tail.prev = head;
        }

        public void addToHead(int key, int value) {
            ListNode node = new ListNode(key, value);
            node.next = head.next;
            node.prev = head;
            if (node.next != null) node.next.prev = node;
            head.next = node;
        }

        public void delete(ListNode node) {
            if (node.prev != null) node.prev.next = node.next;
            if (node.next != null) node.next.prev = node.prev;
        }
    }

    private DLL list;
    private HashMap<Integer, ListNode> map;
    private int capacity = 0;
    private int size = 0;

    public LRUCache(int capacity) {
        list = new DLL();
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int ans = map.get(key).value;
            list.delete(map.get(key));
            list.addToHead(key, ans);
            map.remove(key);
            map.put(key, list.head.next);
            return ans;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            list.delete(map.get(key));
            map.remove(key);
            size--;
        }
        if (!map.containsKey(key) && size == capacity) {
            map.remove(list.tail.prev.key);
            list.delete(list.tail.prev);
            size--;
        }
        list.addToHead(key, value);
        map.put(key, list.head.next);
        size++;
    }
}
