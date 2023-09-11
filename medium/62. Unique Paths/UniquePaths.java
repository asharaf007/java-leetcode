package Java.leetcodeSolution.medium;
//Question Link Below
//https://leetcode.com/problems/unique-paths/
public class UniquePaths {
    public static void main(String[] args) {

        System.out.println(uniquePath(3,2));
    }
    public static int uniquePath(int m, int n) {
        if(m==1&&n==1){
            return 1;
        }
        int right=uniquePath(m,n-1);
        int down=uniquePath(m-1,n);
        return right+down;
    }
}
