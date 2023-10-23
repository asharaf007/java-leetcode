package Java.leetcodeSolution.medium;

//https://leetcode.com/problems/shifting-letters/
public class ShiftingLetters {
    public static void main(String[] args) {
        System.out.println(shiftingLetters("ruu", new int[]{26, 9, 17}));
    }

    public static String shiftingLetters(String s, int[] shifts) {
        char[] sb = s.toCharArray();
        int prev = 0;
        for (int i = sb.length - 1; i >= 0; i--) {
            int n = sb[i] + (shifts[i] + prev) % 26;
            sb[i] = (char) (n > 122 ? n - 26 : n);
            prev = (prev + shifts[i]) % 26;
        }
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < sb.length; i++) sb1.append(sb[i]);
        return sb1.toString();
    }
}
