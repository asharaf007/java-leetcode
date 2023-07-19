package Java.leetcodeSolutions.medium;
import java.util.HashMap;
import java.util.Random;
//Question link below
//https://leetcode.com/problems/insert-delete-getrandom-o1/
public class RandomizedSet {
    private Random random=new Random();
    private HashMap<Integer,Node> map;
    private class Node{
        int val;
        Node next;
        Node prev;
        public Node(int val){
            this.val=val;
            this.next=null;
            this.prev=null;
        }
        public Node(){};
    }
    private Node head;
    private Node tail;
    private int size;
    public RandomizedSet() {
        map=new HashMap<>();
        head=new Node(0);
        tail=head;
        size=0;
    }

    public boolean insert(int val) {
        if(!map.containsKey(val)){
            Node temp=new Node(val);
            map.put(val,temp);
            tail.next=temp;
            temp.prev=tail;
            tail=temp;
            size++;
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        Node temp=map.get(val);
        if(temp==tail){
            tail=tail.prev;
        }
        if(temp.next!=null) temp.next.prev=temp.prev;
        if(temp.prev!=null)temp.prev.next=temp.next;
        map.remove(val);
        size--;
        return true;
    }

    public int getRandom() {
        int rand=random.nextInt(size);
        Node temp=head.next;
        for (int i = 0; i < rand ; i++) {
            temp=temp.next;
        }
        return temp.val;
    }
}