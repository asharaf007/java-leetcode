package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/maximum-number-of-removable-characters/
public class RemovableCharacters {
    public static void main(String[] args) {
        System.out.println(maximumRemovals("abcacb","ab",new int[]{3,1,0}));
    }
    public static int maximumRemovals(String s, String p, int[] removable) {
        boolean[] marked=new boolean[s.length()];
        if(!isSubseq(s,p,marked)) return 0;
        int l=0,r=removable.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            for(int i=l;i<=mid;i++) marked[removable[i]]=true;
            if(isSubseq(s,p,marked)) l=mid+1;
            else{
                for(int i=l;i<=mid;i++) marked[removable[i]]=false;
                r=mid-1;
            }
        }
        return l;
    }
    private static boolean isSubseq(String s,String p,boolean[] m){
        int i=0,j=0;
        while(i<s.length()&&j<p.length()){
            while(i<s.length()&&(m[i]||s.charAt(i)!=p.charAt(j)))i++;
            if(i==s.length()) return false;
            i++;j++;
        }
        return j==p.length();
    }
}
