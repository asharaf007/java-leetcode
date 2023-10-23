package Java.leetcodeSolution.medium;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/find-the-winner-of-the-circular-game/
public class FindWinner {
    public static void main(String[] args) {
        System.out.println(findTheWinner(6, 5));
    }

    public static int findTheWinner(int n, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        int i = k;
        while (q.size() > 1) {
            int num = q.remove();
            if (i == 1) i = k;
            else {
                q.add(num);
                i--;
            }
        }
        return q.remove();
    }
}
