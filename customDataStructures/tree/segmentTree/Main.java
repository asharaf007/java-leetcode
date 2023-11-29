package Java.OOPS.customDataStructures.tree.segmentTree;

public class Main {
    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        SegmentTree st = new SegmentTree(a);
        st.update(5,56);
        st.display();
        System.out.println(st.query(2,5));
    }
}
