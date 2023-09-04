package Java.leetcodeSolution.easy;
//https://leetcode.com/problems/excel-sheet-column-title/
public class ExcelSheet {
    public String convertToTitle(int num) {
        if(num<=26) return (char)('A'+num-1)+"";
        int rem=(num-1)%26;
        num=(num-1)/26;
        return convertToTitle(num)+convertToTitle(rem+1);
    }
}
