import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumCostString {
    private class Trie {
        Trie[] children;
        boolean flag;

        Trie() {
            children = new Trie[26];
            flag = false;
        }

        public void insert(String word) {
            insert(word, 0);
        }

        private void insert(String word, int i) {
            if (i == word.length()) {
                flag = true;
                return;
            }
            int index = word.charAt(i) - 'a';
            if (children[index] == null) {
                children[index] = new Trie();
            }
            children[index].insert(word, i + 1);
        }
    }

    public int minimumCost(String target, String[] words, int[] costs) {
        int n = target.length();
        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        Trie root = new Trie();
        for (String word : words) {
            root.insert(word);
        }
        Map<String, Integer> cost = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            cost.put(words[i], costs[i]);
        }
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == Long.MAX_VALUE) {
                continue;
            }
            Trie current = root;
            for (int j = i; j < n; j++) {
                char c = target.charAt(j);
                if (current.children[c - 'a'] == null) {
                    break;
                }
                current = current.children[c - 'a'];
                if (current.flag) {
                    String s = target.substring(i, j + 1);
                    if (cost.containsKey(s)) {
                        dp[j + 1] = Math.min(dp[j + 1], dp[i] + cost.get(s));
                    }
                }
            }
        }

        return dp[n] == Long.MAX_VALUE ? -1 : (int) dp[n];
    }
}
