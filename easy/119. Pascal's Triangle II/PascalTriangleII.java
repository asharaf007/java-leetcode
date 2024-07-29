//https://leetcode.com/problems/pascals-triangle-ii/
public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        List<Integer> curr;
        int i = 1;
        while (i <= rowIndex) {
            curr = new ArrayList<>();
            curr.add(1);
            for (int j = 1; j < prev.size(); j++) {
                curr.add(prev.get(j) + prev.get(j - 1));
            }
            curr.add(1);
            prev = curr;
            i++;
        }
        return prev;
    }
}
