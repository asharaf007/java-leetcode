package Java.leetcodeSolution.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
//https://leetcode.com/problems/all-oone-data-structure/submissions/
public class AllOne {
    private class Node{
        int count;
        LinkedList<String> keys;
        Node next;
        Node prev;
        Node(int count){
            this.count=count;
            keys=new LinkedList<>();
        }
        void addNext(Node node){
            node.next=this.next;
            node.next.prev=node;
            node.prev=this;
            node.prev.next=node;
        }
        void remove(){
            this.prev.next=this.next;
            this.next.prev=this.prev;
        }
    }
    Map<String,Node> map;
    Node head=new Node(0),tail=new Node(0);
    public AllOne() {
        head.next=tail;
        tail.prev=head;
        map=new HashMap<>();
    }

    public void inc(String key) {
        Node node=map.containsKey(key)?map.get(key):head;
        node.keys.remove(key);
        int count=node.count+1;
        if(node.next.count!=count) node.addNext(new Node(count));
        node.next.keys.add(key);
        map.put(key,node.next);
        if(node!=head&&node.keys.isEmpty()) node.remove();
    }

    public void dec(String key) {
        Node node=map.get(key);
        node.keys.remove(key);
        int count=node.count-1;
        if(count!=0){
            if(node.prev.count!=count) node.prev.addNext(new Node(count));
            node.prev.keys.add(key);
            map.put(key,node.prev);
        }
        else map.remove(key);
        if(node.keys.isEmpty()) node.remove();
    }

    public String getMaxKey() {
        if(head.next==tail) return "";
        return tail.prev.keys.get(0);
    }

    public String getMinKey() {
        if(head.next==tail) return "";
        return head.next.keys.get(0);
    }
}
