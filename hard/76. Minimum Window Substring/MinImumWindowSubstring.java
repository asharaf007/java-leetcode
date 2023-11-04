package Java.leetcodeSolution.hard;

import java.util.HashMap;

//https://leetcode.com/problems/minimum-window-substring/
public class MinImumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(new MinImumWindowSubstring().minWindow("ADOBECODEABANC","BCO"));
    }
    public String minWindow(String s, String t) {
        int st=0,end=s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++) map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        int left = 0, right = 0,count=0;
        while(right<s.length()){
            if(map.containsKey(s.charAt(right))){
                if(map.get(s.charAt(right))>0) count++;
                map.put(s.charAt(right),map.get(s.charAt(right))-1);
            }
            right++;
            if(count<t.length()) continue;
            while(true){
                if(!map.containsKey(s.charAt(left))){
                    left++;
                    continue;
                }
                if(map.get(s.charAt(left))>=0){
                    if(right-left<end-st){
                        st=left;
                        end=right;
                    }
                    break;
                }
                map.put(s.charAt(left),map.get(s.charAt(left))+1);
                left++;
            }
        }
        if(count<t.length()) return "";
        while(true){
            right--;
            if(!map.containsKey(s.charAt(right))) continue;
            if(map.get(s.charAt(right))>=0){
                if(right-left+1<end-st){
                    st=left;
                    end=right+1;
                }
                break;
            }
            map.put(s.charAt(right),map.get(s.charAt(right))+1);
        }
        return s.substring(st, end);
    }
}
