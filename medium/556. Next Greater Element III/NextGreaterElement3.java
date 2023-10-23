package Java.leetcodeSolution.medium;

//https://leetcode.com/problems/next-greater-element-iii/
public class NextGreaterElement3 {
    public static void main(String[] args) {
        System.out.println(nextGreaterElement(7894));
    }

    public static int nextGreaterElement(int n) {
        int[] count = new int[10];
        long m = n;
        int prev = -1, curr = -1;
        while (m > 0) {
            curr = (int) m % 10;
            m /= 10;
            count[curr]++;
            if (curr < prev) {
                int i = curr + 1;
                while (count[i] == 0) i++;
                count[i]--;
                m = m * 10 + i;
                for (i = 0; i < 10; i++) while (count[i]-- > 0) m = m * 10 + i;
                return m > Integer.MAX_VALUE ? -1 : (int) m;
            }
            prev = curr;
        }
        return -1;
    }
}
