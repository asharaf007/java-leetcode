//https://leetcode.com/contest/weekly-contest-405/problems/find-the-encrypted-string/
public class EncryptedString {
    public String getEncryptedString(String s, int k) {
        int size = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(s.charAt((k + i) % size));
        }
        return sb.toString();
    }
}