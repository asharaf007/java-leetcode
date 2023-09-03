package Java.leetcodeSolution.hard;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/lfu-cache/
public class LFUCache {
    private class ListNode{
        int val;
        int key;
        int freq;
        ListNode next;
        ListNode prev;
        public ListNode(int val,int key){
            this.val=val;
            freq=1;
            this.key=key;
        }
    }
    private class LinkedList{
        ListNode head;
        ListNode tail;
        LinkedList(){
            head=new ListNode(0,0);
            tail=new ListNode(0,0);
            head.next=tail;
            tail.prev=head;
        }
        public void delete(ListNode node) {
            node.prev.next=node.next;
            node.next.prev=node.prev;
        }
        public void insertB4tail(ListNode node){
            node.next=tail;
            node.prev=tail.prev;
            tail.prev.next=node;
            tail.prev=node;
        }
        public boolean isEmpty(){
            return head.next==tail;
        }
    }
    int minFreq;
    int capacity;
    Map<Integer,LinkedList> listMap;
    Map<Integer,ListNode> nodeMap;
    public LFUCache(int capacity) {
        listMap=new HashMap<>();
        nodeMap=new HashMap<>();
        this.capacity=capacity;
        minFreq=1;
    }
    private void putInList(ListNode node){
        if(!listMap.containsKey(node.freq)){
            LinkedList temp=new LinkedList();
            listMap.put(node.freq,temp);
        }
        listMap.get(node.freq).insertB4tail(node);
    }

    public int get(int key) {
        if(!nodeMap.containsKey(key)) return -1;
        ListNode curr=nodeMap.get(key);
        LinkedList list=listMap.get(curr.freq);
        list.delete(curr);
        if(curr.freq++==minFreq&&list.isEmpty()) minFreq++;
        putInList(curr);
        return curr.val;
    }

    public void put(int key, int value) {
        if(!nodeMap.containsKey(key)){
            ListNode curr=new ListNode(value,key);
            if(nodeMap.size()==capacity){
                LinkedList list=listMap.get(minFreq);
                ListNode temp=list.head.next;
                list.delete(temp);
                nodeMap.remove(temp.key);
            }
            minFreq=1;
            nodeMap.put(key,curr);
            putInList(curr);
        }
        else{
            nodeMap.get(key).val=value;
            get(key);
        }
    }
}
