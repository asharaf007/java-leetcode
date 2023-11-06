package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/seat-reservation-manager/
import java.util.PriorityQueue;

public class SeatManager {
    PriorityQueue<Integer> pq;
    int index;
    public SeatManager(int n) {
        index++;
        pq=new PriorityQueue<>(n);
    }

    public int reserve() {
        return pq.isEmpty()?index++:pq.poll();
    }

    public void unreserve(int seatNumber) {
        pq.offer(seatNumber);
    }
}
