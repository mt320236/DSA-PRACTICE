// Problem: Matrix Diagonal Sum 
// Approach: Single loop, skip middle element for odd matrix
// Time: O(n) | Space: O(1)

class Solution {
    public int diagonalSum(int[][] mat) {
        int sum=0;
        for(int i=0;i<mat.length;i++){
            sum=sum+mat[i][i];
            if(i!=mat.length-i-1){
                sum=sum+mat[i][mat.length-i-1];
            }
        }
        return sum;
    }
}
