package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/design-linked-list/
class MyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int size;
    private class ListNode {
        public ListNode next;
        public int val;
        public ListNode(){}
        public ListNode(int val){
            this.val=val;
        }
    }

    public MyLinkedList() {
        this.head=null;
        this.tail=null;
        size=0;
    }

    public int get(int index) {
        if(index>=size){
            return -1;
        }
        ListNode temp=head;
        while(index>0){
            temp=temp.next;
            index--;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        ListNode temp = new ListNode(val);
        if(head==null){
            tail=temp;
        }else {
            temp.next = head;
        }
        head = temp;
        size++;
    }

    public void addAtTail(int val) {
        ListNode temp = new ListNode(val);
        if(tail==null){
            head=temp;
        }else {
            tail.next = temp;
        }
        tail=temp;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if(index==0){
            addAtHead(val);
            return;
        }
        if(index==size){
            addAtTail(val);
            return;
        }
        if(index>size) return;
        ListNode temp=head;
        while(index>1){
            temp=temp.next;
            index--;
        }
        ListNode node =new ListNode(val);
        node.next=temp.next;
        temp.next=node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index>=size) return;
        if(index==0){
            removeHead();
            return;
        }
        if(index==size-1){
            removeTail();
            return;
        }
        ListNode temp=head;
        while(index>1){
            temp=temp.next;
            index--;
        }
        temp.next=temp.next.next;
        size--;
    }
    private void removeHead(){
        if(head==null) return;
        head=head.next;
        size--;
    }
    private void removeTail(){
        if(tail==null) return;
        ListNode temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
        tail=temp;
        size--;
    }
}
