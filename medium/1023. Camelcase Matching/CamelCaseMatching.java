package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/camelcase-matching/
import java.util.ArrayList;
import java.util.List;
public class CamelCaseMatching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans=new ArrayList<>();
        for(int i=0;i<queries.length;i++) ans.add(isMatching(queries[i],pattern));
        return ans;
    }
    private boolean isMatching(String s,String p){
        int i=0,j=0;
        while(i<s.length()&&j<p.length()){
            if(s.charAt(i)==p.charAt(j)) j++;
            else if(s.charAt(i)<'a') return false;
            i++;
        }
        while(i<s.length()) if(s.charAt(i++)<'a') return false;
        return j==p.length();
    }
}
