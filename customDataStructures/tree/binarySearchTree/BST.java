package Java.OOPS.customDataStructures.tree.binarySearchTree;

public class BST {
    //IMPLEMENTATION BELOW

    private static class Node {
        private Node left;
        private Node right;
        private int val;
        private int height;

        public int getValue() {
            return this.val;
        }

        Node(int val) {
            this.val = val;
        }
    }
    public Node root() {
        return root;
    }
    private Node root;

    public Node insert(int val) {
        if (this.root == null) {
            this.root = new Node(val);
            return this.root;
        }
        return insert(this.root, val);
    }

    private Node insert(Node node, int val) {
        if (node == null) {
            node = new Node(val);
            return node;
        }
        if (val < node.val) {
            node.left = insert(node.left, val);
        } else {
            node.right = insert(node.right, val);
        }
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        return node;
    }

    public void insert(int[] nums) {
        for (int num : nums) {
            insert(num);
        }
    }

    public void display() {
        display(this.root, "the root node: ");
    }

    private void display(Node node, String message) {
        if (node == null) return;
        System.out.println(message + node.val);
        display(node.left, "the left node of " + node.val + " : ");
        display(node.right, "the right node of " + node.val + " : ");
    }

    public int getHeight(Node node) {
        if (node == null) return -1;
        return node.height;
    }
}
