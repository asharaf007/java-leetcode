package Java.leetcodeSolution.hard;

import java.util.Arrays;

//https://leetcode.com/problems/orderly-queue/
class OrderlyQueue{
    public static void main(String[] args){
        OrderlyQueue obj=new OrderlyQueue();
        System.out.println(obj.orderlyQueue("ryugkagfiagbuaebvil",1));
    }
    public String orderlyQueue(String s, int k) {
        if(k==1){
            String min=s;
            for(int i=1;i<s.length();i++){
                String curr=s.substring(i)+s.substring(0,i);
                if(curr.compareTo(min)<0) min=curr;
            }
            return min;
        }
        char[] str=s.toCharArray();
        Arrays.sort(str);
        StringBuilder sb=new StringBuilder();
        for(char ch:str) sb.append(ch);
        return sb.toString();
    }
}
