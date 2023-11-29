package Java.OOPS.customDataStructures.tree.AVLtree;

public class AVL {
    //IMPLEMENTATION BELOW
    private static class Node {
        private int val;
        private Node left;
        private Node right;
        private int height;

        public int getValue() {
            return val;
        }

        Node(int val) {
            this.val = val;
        }
    }
    public Node root(){
        return root;
    }

    private Node root;

    public void insert(int val) {
        root=insert(root,val);
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
        return rotate(node);
    }

    private Node rotate(Node node) {
        if(getHeight(node.left) - getHeight(node.right)>1){
            //left case
            if (getHeight(node.left.left) > getHeight(node.left.right))
                //left left case
                return rightRotate(node);
            if(getHeight(node.left.left) < getHeight(node.left.right)){
                    //left right case
                    node.left = leftRotate(node.left);
                    return rightRotate(node);
            }
        }
        if(getHeight(node.right) - getHeight(node.left) > 1) {
            //right case
            if (getHeight(node.right.right) > getHeight(node.right.left))
                //right right case
                return leftRotate(node);
            if(getHeight(node.right.right) < getHeight(node.right.left)){
                    //right left case
                    node.right = rightRotate(node.right);
                    return leftRotate(node);
            }
        }
        return node;
    }
    private Node rightRotate(Node node) {
        Node c=node.left;
        Node t=c.right;
        c.right=node;
        node.left=t;
        node.height=Math.max(getHeight(node.left),getHeight(node.right))+1;
        c.height=Math.max(getHeight(c.left),getHeight(c.right))+1;
        return c;
    }
    private Node leftRotate(Node node) {
        Node c=node.right;
        Node t=c.left;
        c.left=node;
        node.right=t;
        node.height=Math.max(getHeight(node.left),getHeight(node.right))+1;
        c.height=Math.max(getHeight(c.left),getHeight(c.right))+1;
        return c;
    }

    public void insert(int[] nums) {
        for (int num : nums) insert(num);
    }

    public void display() {
        display(root, "the root node: ");
    }

    private void display(Node node, String message) {
        if (node == null) return;
        System.out.println(message + node.val);
        display(node.left, "the left node of " + node.val + " : ");
        display(node.right, "the right node of " + node.val + " : ");
    }
    public int height(){
        return getHeight(root);
    }

    private int getHeight(Node node) {
        if (node == null) return -1;
        return node.height;
    }
}
