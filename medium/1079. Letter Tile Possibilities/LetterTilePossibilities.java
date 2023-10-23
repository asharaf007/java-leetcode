package Java.leetcodeSolution.medium;

import java.util.ArrayList;
import java.util.HashSet;

//https://leetcode.com/problems/letter-tile-possibilities/
public class LetterTilePossibilities {
    public static void main(String[] args) {
        System.out.println(numTilePossibilities("aaabbcd"));
    }

    public static int numTilePossibilities(String tiles) {
        ArrayList<String> list = new ArrayList<>();
        list.add(tiles.charAt(0) + "");
        HashSet<String> set = new HashSet<>();
        set.add(list.get(0));
        for (int i = 1; i < tiles.length(); i++) {
            int size = list.size();
            char ch = tiles.charAt(i);
            for (int j = 0; j < size; j++) {
                String s = list.get(j);
                for (int k = 0; k <= s.length(); k++) {
                    String sub = s.substring(0, k) + ch + s.substring(k);
                    if (!set.contains(sub)) {
                        list.add(sub);
                        set.add(sub);
                    }
                }
            }
            if (!set.contains(ch + "")) {
                list.add(ch + "");
                set.add(ch + "");
            }
        }
        return list.size();
    }

}
