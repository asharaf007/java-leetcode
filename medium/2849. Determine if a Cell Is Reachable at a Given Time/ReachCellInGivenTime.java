package Java.leetcodeSolution.medium;

//https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time/
public class ReachCellInGivenTime {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx && sy == fy) return t != 1;
        int x = sx > fx ? sx - fx : fx - sx;
        int y = sy > fy ? sy - fy : fy - sy;
        return Math.max(x, y) <= t;
    }
}
