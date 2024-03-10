import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/count-ways-to-build-rooms-in-an-ant-colony/
class CountWays {
    int[] fact;
    int[] inverseFact;
    List<Integer>[] childrens;
    int mod = (int) 1e9 + 7;
    BigInteger m = BigInteger.valueOf(mod);
    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;
        fact = new int[n];
        inverseFact = new int[n];
        childrens = new List[n];
        fact[0] = 1;
        inverseFact[0] = BigInteger.ONE.modInverse(m).intValue();
        for (int i = 0; i < n; i++) {
            childrens[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            fact[i] = (int) ((long) fact[i - 1] * i % mod);
            inverseFact[i] = BigInteger.valueOf(fact[i]).modInverse(m).intValue();
            childrens[prevRoom[i]].add(i);
        }
        return helper(0)[0];
    }
    private int[] helper(int node) {
        List<Integer> childs = childrens[node];
        int ways = 1;
        int childCount = 0;
        for (int child : childs) {
            int[] small = helper(child);
            long permutations = (long) fact[childCount + small[1]] *
                    inverseFact[small[1]] % mod *
                    inverseFact[childCount] % mod;
            ways = (int) ((((ways * permutations) % mod) * small[0]) % mod);
            childCount = (int) ((long) childCount + small[1]) % mod;
        }
        childCount = (childCount + 1) % mod;
        return new int[] { ways, childCount };
    }
}