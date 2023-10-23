package Java.leetcodeSolution.easy;

//https://leetcode.com/problems/to-lower-case/
public class ToLowerCase {
    public static void main(String[] args) {
        System.out.println(toLowerCase("afwHLALHGEAf,wGfASLSIHOASI   ,qi$%^#@*&^#@&*$*"));
    }

    public static String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 65 && c <= 90) c += 32;
            sb.append(c);
        }
        return sb.toString();
    }
}
