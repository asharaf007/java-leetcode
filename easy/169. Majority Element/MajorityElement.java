package Java.leetcodeSolution.easy;
//Question Link Below
//https://leetcode.com/problems/majority-element/

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        //boyer-moore voting algorithm
        int count = 0;//initially count of majority and other element is balanced
        int majority = 5;//create majority and set it for any number
        for (int n : nums) {
            //if count=0 then set majority to element at that index
            if (count == 0) {
                majority = n;
            }
            //if element at index is same as majority then increase count by 1
            //if not then decrease count by 1
            if (n == majority) {
                count += 1;
            } else {
                count -= 1;
            }
        }
        //return majority
        return majority;
    }
}
