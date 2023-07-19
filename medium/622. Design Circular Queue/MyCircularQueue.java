package Java.leetcodeSolutions.medium;
//question link
//https://leetcode.com/problems/design-circular-queue/
public class MyCircularQueue {
    private Node front;
    private Node rear;
    private int capacity;
    private int size;
    private class Node{
        Node next;
        int val;
        Node(){};
        Node(int value){
            this.val=value;
            this.next=null;
        }
    }
    public MyCircularQueue(int k) {
        this.front=null;
        this.rear=null;
        this.capacity=k;
        this.size=0;
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        if(front!=null){
            rear.next=new Node(value);
            rear=rear.next;
            rear.next=front;
        }
        else{
            front=new Node(value);
            rear=front;
            rear.next=front;
        }
        size++;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        if(front.next==front){
            front=null;
            rear=null;
        }else {
            front = front.next;
            rear.next = front;
        }
        size--;
        return true;
    }

    public int Front() {
        return isEmpty()?-1:front.val;
    }

    public int Rear() {
        return isEmpty()?-1:rear.val;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size==capacity;
    }
}
