//https://leetcode.com/problems/first-unique-character-in-a-string/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int firstUniqChar(String s) {
        Queue<Character> q=new LinkedList<>();
        int[] firstOccurence=new int[26];
        Arrays.fill(firstOccurence,-1); // -1 means character yet to be seen 
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(!q.isEmpty()&&q.peek()==c){
                q.remove();
                while(!q.isEmpty()&&firstOccurence[q.peek()-'a']==-2){
                    q.remove();
                }
            }
            if(firstOccurence[c-'a']==-1){
                q.add(c);
                firstOccurence[c-'a']=i;
            }else{
                firstOccurence[c-'a']=-2; // -2 means character has been seen more than 1 time
            }
        }
        return q.isEmpty()?-1:firstOccurence[q.peek()-'a'];
    }
}