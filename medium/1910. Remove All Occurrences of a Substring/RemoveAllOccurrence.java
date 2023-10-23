package Java.leetcodeSolution.medium;

//https://leetcode.com/problems/remove-all-occurrences-of-a-substring/
public class RemoveAllOccurrence {
    public static void main(String[] args) {
        String s = "asharaf";
        System.out.println(removeOccurrences(s, "sh"));
    }

    public static String removeOccurrences(String s, String sub) {
        if (sub.length() > s.length() || !s.contains(sub)) {
            return s;
        }
        String s1 = s.substring(0, s.indexOf(sub)) + s.substring(s.indexOf(sub) + sub.length());
        return removeOccurrences(s1, sub);
    }
}
