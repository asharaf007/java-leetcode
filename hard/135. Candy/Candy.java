package Java.leetcodeSolution.hard;
//https://leetcode.com/problems/candy/
public class Candy {
    public static void main(String[] args) {
        System.out.println(candy(new int[]{1,2,5,0,1,5,4,25,25,25,25,16,6,4,2,1,25}));
    }
    public static int candy(int[] ratings) {
        int candy=0,curr=1,i=0;
        while(i< ratings.length-1){
            if(ratings[i+1]>ratings[i]){
                candy+=curr++;i++;
            }
            else if(ratings[i+1]==ratings[i]){
                candy+=curr;
                curr=1;i++;
            }
            else{
                int length=0;
                while(i<ratings.length-1&&ratings[i+1]<ratings[i]) {i++;length++;}
                if(length<curr) candy+=curr;
                else candy+=length+1;
                candy+=(((length)*(length+1))/2)-1;
                curr=1;
            }
        }
        return candy+curr;
    }
}
