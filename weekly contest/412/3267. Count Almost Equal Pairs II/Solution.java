//https://leetcode.com/problems/count-almost-equal-pairs-ii/
class Solution {
    public int countPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (areAlmostEqual(nums[i], nums[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean areAlmostEqual(int x, int y) {
        if(x==y){
            return true;
        }
        int[] diff = new int[4];
        int count = 0;

        for (int i = 0; i < 10 && (x > 0 || y > 0); i++) {
            int digitX = x % 10;
            int digitY = y % 10;

            if (digitX != digitY) {
                if (count == 4) {
                    return false;
                }
                diff[count++] = digitX * 10 + digitY;
            }

            x /= 10;
            y /= 10;
        }
        if (count == 2) {
            return diff[0] / 10 == diff[1] % 10 && diff[0] % 10 == diff[1] / 10;
        }
        if (count == 3) {
            return (diff[0] / 10 == diff[1] % 10 && diff[1] / 10 == diff[2] % 10 && diff[2] / 10 == diff[0] % 10) ||
                    (diff[0] / 10 == diff[2] % 10 && diff[1] / 10 == diff[0] % 10 && diff[2] / 10 == diff[1] % 10);
        }
        if (count == 4) {
            return (diff[0] / 10 == diff[1] % 10 && diff[1] / 10 == diff[0] % 10 && diff[2] / 10 == diff[3] % 10
                    && diff[3] / 10 == diff[2] % 10) ||
                    (diff[0] / 10 == diff[2] % 10 && diff[2] / 10 == diff[0] % 10 && diff[1] / 10 == diff[3] % 10
                            && diff[3] / 10 == diff[1] % 10)
                    ||
                    (diff[0] / 10 == diff[3] % 10 && diff[3] / 10 == diff[0] % 10 && diff[1] / 10 == diff[2] % 10
                            && diff[2] / 10 == diff[1] % 10);
        }
        return count==0;
    }
}
