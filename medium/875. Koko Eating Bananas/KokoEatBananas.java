package Java.leetcodeSolution.medium;

//https://leetcode.com/problems/koko-eating-bananas/
public class KokoEatBananas {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{1, 1, 1, 999999999}, 10));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = 0;
        for (int i = 0; i < piles.length; i++) if (piles[i] > hi) hi = piles[i];
        int mid = lo + (hi - lo) / 2;
        while (lo <= hi) {
            int hour = 0;
            for (int x : piles) {
                hour += ((x - 1) / mid) + 1;
                if (hour > h) break;
            }
            if (hour > h) lo = mid + 1;
            else hi = mid - 1;
            mid = lo + (hi - lo) / 2;
        }
        return hi + 1;
    }
}
