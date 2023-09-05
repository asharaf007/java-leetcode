package Java.leetcodeSolution.medium;
//Question Link Below
//https://leetcode.com/problems/group-anagrams/

import java.util.*;
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs={"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans=new ArrayList<>();
        Set<char[]> set=new HashSet<>();
        for(int i=0;i<strs.length;i++){
            char[] c=strs[i].toCharArray();
            Arrays.sort(c);
            if(!set.contains(c)) {
                set.add(c);
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                for (int j = i+1; j < strs.length; j++) {
                    char[] s = strs[j].toCharArray();
                    Arrays.sort(s);
                    if (set.contains(s)) {
                        list.add(strs[j]);
                    }
                }
                ans.add(list);
            }
        }
        return ans;
    }
}
