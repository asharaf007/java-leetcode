package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
public class VerifyPreorderSerialization {
    public boolean isValidSerialization(String preorder){
        String[] arr = preorder.split(",");
        int stack=0,i=0;
        while(i<arr.length){
            if(arr[i].equals("#")){
                if(stack==0) break;
                stack--;
            }
            else stack++;
            i++;
        }
        return stack==0&&++i==arr.length;
    }
}
