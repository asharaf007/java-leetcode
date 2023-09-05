package Java.leetcodeSolution.easy;
//Question Link Below
//https://leetcode.com/problems/isomorphic-strings/
import java.util.HashMap;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s="title";
        String t="ptper";
        System.out.println(isIsomorphic(s,t));
    }
    public static boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int n=s.length();
        HashMap<Character,Character> map=new HashMap<>();
        for(int i=0;i<n;i++){
            char c1=s.charAt(i);
            char c2=t.charAt(i);
            if(!map.containsKey(c1)&&!map.containsValue(c2)) {
                map.put(c1, c2);
            }
            if(map.containsKey(c1)&&map.get(c1)!=c2){
                return false;
            }
            if(!map.containsKey(c1)&&map.containsValue(c2)) {
                return false;
            }
        }
        return true;
    }
}
