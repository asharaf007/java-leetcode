package Java.leetcodeSolution.week357;
//https://leetcode.com/contest/weekly-contest-357/problems/faulty-keyboard/
public class FaultyKeyboard {
    public static void main(String[] args) {
        FaultyKeyboard object=new FaultyKeyboard();
        System.out.println(object.finalString("striing"));
    }
    public String finalString(String s) {
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='i'){
                s=reverse(s.substring(0,i))+s.substring(i+1);
                i--;
            }
        }
        return s;
    }

    private String reverse(String s) {
       StringBuilder ans=new StringBuilder();
       for(int i=0;i<s.length();i++){
           ans.insert(0,s.charAt(i));
       }
       return ans.toString();
    }
}
