package Java.leetcodeSolution.medium;

//https://leetcode.com/problems/design-browser-history/
public class BrowserHistory {
    private class Url {
        private String address;
        private Url next;
        private Url prev;

        public Url(String s) {
            address = s;
        }
    }

    Url curr;

    public BrowserHistory(String homepage) {
        curr = new Url(homepage);
    }

    public void visit(String url) {
        curr.next = new Url(url);
        curr.next.prev = curr;
        curr = curr.next;
    }

    public String back(int steps) {
        while (curr.prev != null && steps-- > 0) curr = curr.prev;
        return curr.address;
    }

    public String forward(int steps) {
        while (curr.next != null && steps-- > 0) curr = curr.next;
        return curr.address;
    }
}
