//https://leetcode.com/problems/minimum-number-of-frogs-croaking/
public class Solution {
    public int minNumberOfFrogs(String s) {
        Map<Character,Integer> map=new HashMap<>();
        Map<Character,Character> prevChar=new HashMap<>();
        map.put('c',0);
        map.put('r',0);
        map.put('o',0);
        map.put('a',0);
        map.put('k',0);
        map.put('b',1000001);
        prevChar.put('c','b');
        prevChar.put('r','c');
        prevChar.put('o','r');
        prevChar.put('a','o');
        prevChar.put('k','a');
        int max=0;
        int minus=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!prev.containsKey(ch)){
                return -1;
            }
            if(map.get(ch)>=map.get(prev.get(ch))){
                return -1;
            }
            if(ch=='k'){
                max=Math.max(max,map.get('c')-minus);
                minus++;
            }else{
                map.put(ch,map.get(ch)+1);
            }
        }
        if(map.get('c')-minus>0){
            return -1;
        }
        return max;
    }
}
