package Java.OOPS.customDataStructures.tree.binarySearchTree;

public class Main {
    public static void main(String[] args) {
        BST tree = new BST();
        int[] nums = {4, 6, 2, 4, 9, 8, 5, 0, 1, 3};
        tree.insert(nums);
        tree.display();
    }
}
