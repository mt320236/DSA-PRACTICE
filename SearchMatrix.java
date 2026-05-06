
// Problem: Search a 2D Matrix 
// Approach: Start from top-right or bottom-left corner
// Time: O(m+n) | Space: O(1)


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length-1;
        int column=0;
        while(row>=0 && column<=matrix[0].length-1){
            if(target==matrix[row][column]){
                return true;
            }
            else if(target>matrix[row][column]){
                column++;
            }
            else if(target<matrix[row][column]){
                row--;
            }
            
        }
        return false;
        
    }
}
