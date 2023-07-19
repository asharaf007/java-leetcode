package Java.leetcodeSolutions.medium;
//Question Link Below
//https://leetcode.com/problems/kth-largest-element-in-an-array/
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums={3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums,4));
    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue=new PriorityQueue<>(Comparator.reverseOrder());
        for(int n:nums){
            queue.offer(n);
        }
        while(k>1){
            queue.remove();
            k--;
        }
        return queue.peek();
    }
}
