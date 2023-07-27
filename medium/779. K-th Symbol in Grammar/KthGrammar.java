package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/k-th-symbol-in-grammar/
public class KthGrammar {
    public static void main(String[] args) {
        System.out.println(kthGrammar(2,2));
    }
    public static int kthGrammar(int n, int k) {
        if(k==1||n==1){
            return 0;
        }
        int len=1<<(n-1);
        if(k<=len/2){
            return kthGrammar(n-1,k);
        }
        return kthGrammar(n-1,k-len/2)==0?1:0;
    }
}
