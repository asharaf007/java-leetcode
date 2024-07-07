public class MinimumCostString {
    String[] words;
    int[] costs;
    long res;

    public int minimumCost(String target, String[] words, int[] costs) {
        this.costs = costs;
        this.words = words;
        res = Long.MAX_VALUE;
        helper(target, 0);
        return (int) res;
    }

    private void helper(String target, int cost) {
        if (target == "") {
            res = Math.min(cost, res);
            return;
        }
        for (int i = 0; i < words.length; i++) {
            int index = match(target, words[i]);
            if (index > 0) {
                helper(target.substring(index), cost + costs[i]);
            }
        }
    }

    private int match(String a, String b) {
        if (a.length() < b.length()) {
            return -1;
        }
        int i = 0;
        while (i < a.length() && i < b.length()) {
            if (a.charAt(i) == b.charAt(i)) {
                i++;
            } else {
                break;
            }
        }
        return i;
    }
}
