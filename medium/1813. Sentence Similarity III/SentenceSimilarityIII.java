package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/sentence-similarity-iii/
public class SentenceSimilarityIII {
    public static void main(String[] args) {
        System.out.println(areSentencesSimilar("A A AAa","A AAa"));
    }
    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.equals(sentence2)) return true;
        if(sentence1.length()<sentence2.length()){
            String temp=sentence1;
            sentence1=sentence2;
            sentence2=temp;
        }
        int i=0;
        while(i<sentence2.length()&&sentence1.charAt(i)==sentence2.charAt(i))i++;
        if(i==sentence2.length()&&sentence1.charAt(i)==' ') return true;
        int j= sentence1.length()-1,k=sentence2.length()-1;
        while(0<=k&&sentence1.charAt(j)==sentence2.charAt(k)){j--;k--;}
        if(i<=k) return false;
        if(i<j) return sentence1.charAt(i-1)==' '&&sentence1.charAt(j+1)==' ';
        return k==-1;
    }
}
