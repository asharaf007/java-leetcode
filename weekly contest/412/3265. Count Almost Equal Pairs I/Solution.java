//https://leetcode.com/problems/count-almost-equal-pairs-i/
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
        String sx = String.valueOf(x);
        String sy = String.valueOf(y);
        int diff = Math.abs(sx.length() - sy.length());
        String zeros = "";
        for (int k = 0; k < diff; k++) {
            zeros += '0';
        }
        if (sx.length() < sy.length()) {
            sx = zeros + sx;
        } else {
            sy = zeros + sy;
        }
        // If lengths differ by more than 1, they can't be made equal by swapping two
        // digits.

        // Count differences in corresponding digits.
        int diffCount = 0;
        int firstDiffIndex = -1, secondDiffIndex = -1;

        for (int i = 0; i < sx.length(); i++) {
            if (sx.charAt(i) != sy.charAt(i)) {
                diffCount++;
                if (diffCount == 1) {
                    firstDiffIndex = i;
                } else if (diffCount == 2) {
                    secondDiffIndex = i;
                } else {
                    return false; // More than two differences
                }
            }
        }

        // If there are exactly two differences, check if swapping would make them
        // equal.
        if (diffCount == 2) {
            return sx.charAt(firstDiffIndex) == sy.charAt(secondDiffIndex) &&
                    sx.charAt(secondDiffIndex) == sy.charAt(firstDiffIndex);
        }

        // If no differences, they are equal.
        return diffCount == 0;
    }
}
