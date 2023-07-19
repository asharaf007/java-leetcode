package Java.leetcodeSolutions.medium;
//https://leetcode.com/problems/design-front-middle-back-queue/
public class FrontMiddleBackQueue {
    public static void main(String[] args) {
        FrontMiddleBackQueue queue=new FrontMiddleBackQueue();
        queue.pushFront(888438);
        queue.pushMiddle(772690);
        queue.pushMiddle(375192);
        queue.pushFront(411268);
        queue.pushFront(885613);
        queue.pushMiddle(508187);
        System.out.println(queue.popMiddle());
        System.out.println(queue.popMiddle());
        queue.pushMiddle(111498);
        queue.pushMiddle(296008);
        System.out.println(queue.popFront());
    }
    private Node front;
    private Node back;
    private Node middle;
    private int size;
    private class Node{
        Node next;
        Node prev;
        int val;
        Node(){};
        Node(int value){
            this.val=value;
            this.next=null;
            this.prev=null;
        }
    }
    public FrontMiddleBackQueue() {
        front=null;
        back=null;
        middle=null;
        size=0;
    }

    public void pushFront(int val) {
        Node node=new Node(val);
        if(front==null){
            front=node;
            back=front;
            middle=front;
        }
        else{
            node.next=front;
            front.prev=node;
            front=node;
        }
        if(size%2==1) middle=middle.prev;
        size++;
    }

    public void pushMiddle(int val) {
        Node node=new Node(val);
        if(middle==null){
            front=node;
            back=front;
            middle=front;
        }else{
            if(size%2==0){
                node.next=middle.next;
                if(node.next!=null)node.next.prev=node;
                middle.next=node;
                node.prev=middle;
                middle=node;
            }
            else{
                if(middle.prev!=null)middle.prev.next=node;
                node.prev=middle.prev;
                middle.prev=node;
                node.next=middle;
                middle=node;
            }
            if(middle.prev==null){
                front=middle;
            }
        }

        size++;
    }

    public void pushBack(int val) {
        Node node=new Node(val);
        if(back==null){
            front=node;
            back=front;
            middle=front;
        }
        else{
            back.next=node;
            node.prev=back;
            back=node;
        }
        if(size>0&&size%2==0) middle=middle.next;
        size++;
    }

    public int popFront() {
        if(front==null){
            return -1;
        }
        int num=front.val;
        front=front.next;
        if(front==null){
            back=null;
            middle=null;
        }else front.prev=null;
        if(size%2==0&&middle!=null) middle=middle.next;
        size--;
        return num;
    }

    public int popMiddle() {
        if(middle==null){
            return -1;
        }
        int num=middle.val;
        if(middle.prev!=null)middle.prev.next=middle.next;
        if(middle.next!=null)middle.next.prev=middle.prev;
        if(size%2==0){
            middle=middle.next;
        }
        else{
            middle=middle.prev;
        }
        if(middle==null){
            front=null;
            back=null;
        }
        if(size==2){
            front=middle;
        }
        size--;
        return num;
    }

    public int popBack() {
        if(back==null){
            return -1;
        }
        int num=back.val;
        back=back.prev;
        if(back==null){
            front=null;
            middle=null;
        }else back.next=null;
        if(size%2==1&&middle!=null) middle=middle.prev;
        size--;
        return num;
    }
}
