//https://leetcode.com/problems/vowels-game-in-a-string/
public class VowelGame {
    public boolean doesAliceWin(String s) {
        int vowelCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelCount++;
            }
        }
        return vowelCount > 0;
    }
}
