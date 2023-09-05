package Java.leetcodeSolution.medium;

import java.util.Arrays;
import java.util.Stack;
//question link
//https://leetcode.com/problems/min-stack/
public class MinStack {

    private int[] stack;
    private Stack<Integer> st;
    private int index=0;
    private int size=10;
    public MinStack() {
        stack=new int[size];
        st=new Stack<>();
    }

    public void push(int val) {
        if(isFull()){
            stack=Arrays.copyOf(stack,size*2);
            size*=2;
        }
        if((!st.isEmpty()&&st.peek()>=val)||st.isEmpty()){
            st.push(val);
        }
        stack[index++]=val;
    }

    public void pop() {
        if(this.top()==st.peek()){
            st.pop();
        }
        index--;
    }

    public int top() {
        return stack[index-1];
    }

    public int getMin() {
        return st.peek();
    }
    private boolean isFull(){
        return index==size;
    }
}
