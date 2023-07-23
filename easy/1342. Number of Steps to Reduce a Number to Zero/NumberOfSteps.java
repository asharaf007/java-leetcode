package Java.leetcodeSolution.easy;
//https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
public class NumberOfSteps {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(5));
    }
    public static int numberOfSteps(int num) {
        if(num==0){
            return 0;
        }
        if(num%2==0){
            return 1+numberOfSteps(num/2);
        }
        return 1+numberOfSteps(num-1);
    }
}
