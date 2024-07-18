
import java.util.PriorityQueue;

//https://leetcode.com/problems/minimum-cost-for-cutting-cake-i/
public class MinimumCost {

    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < horizontalCut.length; i++) {
            pq.add(new int[] { horizontalCut[i], 1 });
        }
        for (int i = 0; i < verticalCut.length; i++) {
            pq.add(new int[] { verticalCut[i], 0 });
        }
        int cost = 0;
        int hcuts = 1;
        int vcuts = 1;
        while (!pq.isEmpty()) {
            int[] cut = pq.poll();
            if (cut[1] == 1) {
                cost += cut[0] * vcuts;
                hcuts++;
            } else {
                cost += cut[0] * hcuts;
                vcuts++;
            }
        }
        return cost;
    }
}