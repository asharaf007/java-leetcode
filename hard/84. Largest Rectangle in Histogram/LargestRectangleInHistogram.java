package Java.leetcodeSolution.hard;

import java.util.Stack;

//question link
//https://leetcode.com/problems/largest-rectangle-in-histogram/

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights={2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int max=0;
        st.push(0);
        for(int i=1;i<heights.length;i++){
            int curr=heights[i];
            while(!st.isEmpty()&&curr<heights[st.peek()]){
                int popped=heights[st.pop()];
                max=Math.max(max,(i-(st.isEmpty()?-1:st.peek())-1)*popped);
            }
            st.push(i);
        }
        int i=heights.length;
        while(!st.isEmpty()){
            int popped=heights[st.pop()];
            max=Math.max(max,(i-(st.isEmpty()?-1:st.peek())-1)*popped);
        }
        return max;
    }
}
