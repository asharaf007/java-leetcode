package Java.leetcodeSolution.medium;

//question link
//https://leetcode.com/problems/design-a-stack-with-increment-operation/
public class StackWithIncrementOperation {
    private int[] stack;
    private int index = 0;
    private int maxSize;

    public StackWithIncrementOperation(int maxSize) {
        stack = new int[maxSize];
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (index < maxSize) {
            stack[index++] = x;
        }
    }

    public int pop() {
        return index == 0 ? -1 : stack[--index];
    }

    public void increment(int k, int val) {
        for (int i = 0; i < k && i < index; i++) {
            stack[i] += val;
        }
    }
}
