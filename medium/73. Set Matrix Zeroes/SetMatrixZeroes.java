package Java.leetcodeSolution.medium;
//https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZeroes {
    public static void main(String[] args) {
       int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
       setZeroes(matrix);
       for(int i=0;i<matrix.length;i++){
           for(int j=0;j<matrix[0].length;j++){
               System.out.print(matrix[i][j]+" ");
           }
           System.out.println();
       }
    }
    //best optimal solution
    //time complexity-  O(mn)
    //space complexity-  O(1)
    public static void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int row0=1;
        //here first row and first column acts as a tracker of those row and column that should be completely zero
        //traverse through the whole matrix and if 0 encounters at matrix[i][j] then make jth column of first row as zero and ith row of first
        // column as zero
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    if(i!=0) {
                        matrix[i][0] = 0;
                    }else{
                        row0=0;
                    }
                    matrix[0][j] = 0;
                }
            }
        }
        //now we traverse again through matrix except first row and first column
        //if element is at i,j then if ith row of first column or jth column of first row or both is marked zero then
        //we will reassign that element to zero
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        //now we have to take care of only first and first column
        //if oth column of first row is 0 then first column that acting as a tracker will be completely zero
        //if row0 is zero then first row which also acting as a tracker will also be completely zero
        if(matrix[0][0]==0){
            for(int i=0;i<n;i++){
                matrix[i][0]=0;
            }
        }
        if(row0==0){
            for(int i=0;i<n;i++){
                matrix[0][i]=0;
            }
        }

    }

}
