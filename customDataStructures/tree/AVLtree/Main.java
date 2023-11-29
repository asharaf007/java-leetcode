package Java.OOPS.customDataStructures.tree.AVLtree;

public class Main {
    public static void main(String[] args) {
        AVL tree=new AVL();
        for(int i=1;i<1000;i++)tree.insert(i);
        tree.display();
        System.out.println(tree.height());
    }
}
