/*
Approach:
1. Place one queen in each column using backtracking.
2. Use three arrays to efficiently track occupied positions:
   - left[row]             -> Checks if a row already has a queen.
   - upperDiagonal[]       -> Checks the upper diagonal.
   - lowerDiagonal[]       -> Checks the lower diagonal.
3. If a position is safe, place the queen and recursively move to the next column.
4. If all columns are filled, one valid arrangement is found, so return 1.
5. Backtrack by removing the queen and continue searching for other valid arrangements.
6. Sum the results returned by all recursive calls to get the total number of valid solutions.

Time Complexity: O(N!)
Space Complexity: O(N) (excluding recursion stack)
*/

class Solution {
    public int totalNQueens(int n) {
        
        
        int [] left=new int[n];
        int [] upperDiagonal=new int[2*n-1];
        int [] lowerDiagonal=new int[2*n-1];
        return solve(n,0,left,upperDiagonal,lowerDiagonal);
        

        
    }
    public int solve(int n,int col,int [] left,int [] upperDiagonal,int []lowerDiagonal){
        int count=0;
        if(col==n){
             
             return 1;
        }
        for(int row=0;row<n;row++){
            if(left[row]==0 && upperDiagonal[n-1+col-row]==0 && lowerDiagonal[row+col]==0){
                
                left[row]=1;
                upperDiagonal[n-1+col-row]=1;
                lowerDiagonal[row+col]=1;
                count+=solve(n,col+1,left,upperDiagonal,lowerDiagonal);
                 
                left[row]=0;
                upperDiagonal[n-1+col-row]=0;
                lowerDiagonal[row+col]=0;
                
            }

        }
        return count;
    }
}
