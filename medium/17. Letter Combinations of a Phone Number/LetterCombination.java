package Java.leetcodeSolution.medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombination {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            ArrayList<String> ans=new ArrayList<String>();
            return ans;
        }
        List<String> list=new ArrayList<>();
        list.add("");
        list.add("");
        list.add("abc");
        list.add("def");
        list.add("ghi");
        list.add("jkl");
        list.add("mno");
        list.add("pqrs");
        list.add("tuv");
        list.add("wxyz");
        return solve(digits,list,"");
    }
    public ArrayList<String> solve(String digits, List<String> list, String comb){
        if(digits.isEmpty()){
            ArrayList<String> ans=new ArrayList<String>();
            ans.add(comb);
            return ans;
        }
        ArrayList<String> ans=new ArrayList<String>();
        int index=digits.charAt(0)-'0';
        String s=list.get(index);
        for(int i=0;i<s.length();i++){
            //recursive call
            List<String> temp=solve(digits.substring(1),list,comb+s.charAt(i));
            ans.addAll(temp);
        }
        return ans;
    }
}
