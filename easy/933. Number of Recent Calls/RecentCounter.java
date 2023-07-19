package Java.leetcodeSolutions.easy;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//question link
//https://leetcode.com/problems/number-of-recent-calls/
public class RecentCounter {
    private Queue<Integer> queue;
    public RecentCounter() {
        queue=new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while(queue.peek()<t-3000){
            queue.poll();
        }
        return queue.size();
    }
}
