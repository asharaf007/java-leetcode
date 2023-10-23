package Java.leetcodeSolution.medium;

import java.util.Arrays;
import java.util.Stack;

//question link
//https://leetcode.com/problems/asteroid-collision/
public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {5, -2, -10, -6, 13, 15, 12, 10, -8, -11, -15};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int num : asteroids) {
            if (num >= 0 || !stack.isEmpty() && !isPositive(stack.peek())) {
                stack.push(num);
                continue;
            }
            while (!stack.isEmpty() && isPositive(stack.peek()) && (num * -1) > stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty() || !isPositive(stack.peek())) {
                stack.push(num);
            } else if (num * -1 == stack.peek()) {
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return new int[]{};
        }
        int[] ans = new int[stack.size()];
        int j = stack.size() - 1;
        while (!stack.isEmpty()) {
            ans[j--] = stack.pop();
        }
        return ans;
    }

    private static boolean isPositive(int num) {
        return num >= 0;
    }
}
