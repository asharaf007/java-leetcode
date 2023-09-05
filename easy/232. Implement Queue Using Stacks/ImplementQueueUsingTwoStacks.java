package Java.leetcodeSolution.easy;

import java.util.*;
//question link
//https://leetcode.com/problems/implement-queue-using-stacks/
class ImplementQueueUsingTwoStacks {
    private Stack<Integer> st1;
    private Stack<Integer> st2;

    public ImplementQueueUsingTwoStacks() {
        this.st1 = new Stack<>();
        this.st2 = new Stack<>();
    }

    public void push(int x){
        st1.push(x);
    }
    public int pop(){
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        int removed=st2.pop();
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
        return removed;
    }
    public int peek(){
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        int peek=st2.peek();
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
        return peek;
    }
    public boolean empty(){
        return st1.isEmpty();
    }
}

//void push(int x) Pushes element x to the back of the queue.
//int pop() Removes the element from the front of the queue and returns it.
//int peek() Returns the element at the front of the queue.
//boolean empty() Returns true if the queue is empty, false otherwise.