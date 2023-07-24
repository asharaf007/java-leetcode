package Java.leetcodeContests.wc355;
//https://leetcode.com/contest/weekly-contest-355/problems/split-strings-by-separator/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode2788 {
    public static void main(String[] args) {
        List<String> words=new ArrayList<>();
        words.add("one.two.three");
        words.add("four.five");
        words.add("six");
        System.out.println(Arrays.toString(splitWordsBySeparator(words,'.').toArray()));
    }
    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> list=new ArrayList<>();
        for(int i=0;i<words.size();i++){
            String s=words.get(i);
            String temp="";
            for(int j=0;j<s.length();j++){
                if(!temp.isEmpty()&&s.charAt(j)==separator){
                    list.add(temp);
                    temp="";
                }
                if(s.charAt(j)!=separator){
                    temp+=s.charAt(j);
                }
            }
            if(!temp.isEmpty()){
                list.add(temp);
            }
        }
        return list;
    }
}
