package Java.leetcodeSolutions.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

//question link
//https://leetcode.com/problems/next-greater-element-i/
public class NextGreaterElement1 {
    public static void main(String[] args) {
        int[] nums1={4,1,2};
        int[] nums2={1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1,nums2)));
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        Stack<Integer> stack=new Stack<>();
        for(int i=nums2.length-1;i>=0;i--){
            int curr=nums2[i];
            while(!stack.isEmpty()&&stack.peek()<curr){
                stack.pop();
            }
            map.put(curr,stack.isEmpty()?-1:stack.peek());
            stack.push(curr);
        }
        for(int i=0;i< nums1.length;i++){
            nums1[i]=map.get(nums1[i]);
        }
        return nums1;
    }
}
