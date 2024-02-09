package Java.leetcodeSolution.hard;
//https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/
import java.util.*;

public class WaysToReorderArray {
    public static void main(String[] args) {
        WaysToReorderArray obj=new WaysToReorderArray();
        System.out.println(obj.numOfWays(new int[]{9,4,2,1,3,6,5,7,8,14,11,10,12,13,16,15,17,18}));
    }
    int[][] p;
    int mod=(int) 1e9+7;
    public int numOfWays(int[] nums) {
        p=new int[nums.length+1][nums.length+1];
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return helper(list)-1;
    }

    private int helper(List<Integer> list) {
        if(list.size()<3) return 1;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int val = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            int num = list.get(i);
            if (num < val) {
                left.add(num);
            } else {
                right.add(num);
            }
        }
        long l=helper(left);
        int r=helper(right);
        int p=permutations(left.size(),right.size());
        int ways =(int)((((l*r)%mod)*p)%mod);
        return ways;
    }

    private int permutations(int size1, int size2) {
        if(p[size1][size2]!=0) return p[size1][size2];
        if (size1 ==0 || size2 ==0) return 1;
        return p[size1][size2]=(int)(((long)permutations(size1-1, size2) + permutations(size1, size2-1))%mod);
    }
}
