//https://leetcode.com/problems/implement-trie-prefix-tree/
public class Trie {
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
        Trie curr = children[word.charAt(i) - 'a'];
        if (curr == null) {
            Trie node = new Trie();
            children[word.charAt(i) - 'a'] = node;
            node.insert(word, ++i);
        } else {
            curr.insert(word, ++i);
        }
    }

    public boolean search(String word) {
        return search(word, 0);
    }

    private boolean search(String word, int i) {
        if (i == word.length()) {
            return flag;
        }
        Trie curr = children[word.charAt(i) - 'a'];
        if (curr == null) {
            return false;
        }
        return curr.search(word, ++i);
    }

    public boolean startsWith(String word) {
        return startsWith(word, 0);
    }

    private boolean startsWith(String word, int i) {
        if (i == word.length()) {
            return true;
        }
        Trie curr = children[word.charAt(i) - 'a'];
        if (curr == null) {
            return false;
        }
        return curr.startsWith(word, ++i);
    }

    public static void main(String[] args) {
        Trie root = new Trie();
        String[] words = { "apple", "apps", "bac", "bat", "apcx" };
        for (String word : words) {
            root.insert(word);
        }
        // root.display();
        System.out.println(root.search("apps"));
        System.out.println(root.search("app"));
        System.out.println(root.startsWith("appl"));
        System.out.println(root.startsWith("bat"));
        System.out.println(root.startsWith("baa"));
        System.out.println(root.search("asharaf"));
        System.out.println(root.startsWith("applee"));
    }
    /*
     * function to display all words in trie
     * 
     * public void display() {
     * display("");
     * }
     * 
     * private void display(String word) {
     * if (flag == true) {
     * System.out.println(word);
     * }
     * for (int i = 0; i < 26; i++) {
     * Trie curr = children[i];
     * if (curr != null) {
     * char ch = (char) ('a' + i);
     * curr.display(word + ch);
     * }
     * }
     * }
     */
}
