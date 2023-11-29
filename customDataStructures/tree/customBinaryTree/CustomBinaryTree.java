package Java.OOPS.customDataStructures.tree.customBinaryTree;

import java.util.Scanner;

public class CustomBinaryTree {
    //IMPLEMENTATION BELOW

    public CustomBinaryTree() {
    }

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
    public Node root(){
        return root;
    }
    private Node root;

    public void populate(Scanner scanner) {
        System.out.println("enter the root node: ");
        int root = scanner.nextInt();
        this.root = new Node(root);
        populate(this.root, scanner);
    }

    private void populate(Node node, Scanner scanner) {
        System.out.println("Do you want to insert left of " + node.val + ": ");
        Boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("enter the node value: ");
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(node.left, scanner);
        }
        System.out.println("Do you want to insert right of " + node.val + ": ");
        Boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("enter the node value: ");
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(node.right, scanner);
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

    public boolean isEmpty() {
        return this.root == null;
    }
}
