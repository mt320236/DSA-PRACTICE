/*
Problem:
Given an m x n matrix, if an element is 0, set its entire row and column to 0.
The operation must be performed in-place.

Approach:
1. Use the first row and first column as markers.
2. If a cell contains 0, mark its row and column by setting the corresponding
   first-row and first-column cells to 0.
3. Use the markers to update the remaining cells.
4. Handle the first column separately using the col0 variable.

Time Complexity: O(m * n)
Space Complexity: O(1)
*/

Approach:
1. Use the first row and first column as markers.
2. If a cell contains 0, mark its entire row and column.
3. Traverse the matrix again and set cells to 0 based on markers.
4. Use an extra variable (col0) to handle the first column separately.

Time Complexity: O(m * n)
Space Complexity: O(1)
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        // col[0]=ar[0][..];
        //row[0]=arr[..][0];
        int col0=1;
        for(int i=0; i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    if(j!=0){
                     matrix[0][j]=0;}
                     else{
                        col0=0;

                     }
                    
                }
            }

        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(matrix[0][0]==0){
            for(int j=0;j<matrix[0].length;j++){
                matrix[0][j]=0;
            }
        }
        if(col0==0){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
        
    }
}
