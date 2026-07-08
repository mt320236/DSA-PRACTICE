/*
LeetCode 51 - N-Queens

Approach:
- Use backtracking to place one queen in each column.
- Track occupied rows, upper diagonals, and lower diagonals
  using three arrays for O(1) safety checks.
- If a position is safe, place the queen, recurse for the
  next column, and backtrack by removing the queen.
- When all columns are processed, convert the board into
  a List<String> and store the solution.

*/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char [][] board=new char[n][n];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                board[i][j]='.';
            }
        }
        int [] leftRow=new int[n];
        int [] upperDiagonal=new int[2*n-1];
        int [] lowerDiagonal=new int[2*n-1];
        List<List<String>> rs=new ArrayList<>();
        solve(0,n,board,leftRow,upperDiagonal,lowerDiagonal,rs);
        return rs;


        
    }
    public void solve(int col,int n,char [][] board,int [] leftRow,int [] upperDiagonal,int [] lowerDiagonal,List<List<String>> rs){
        if(col==n){
            List<String> ls=new ArrayList<>();
            for(int i=0;i<board.length;i++){
                ls.add(new String(board[i]));
            }
            rs.add(ls);
            return;
        }
        for (int row=0;row<n;row++){
            if(leftRow[row]==0 && lowerDiagonal[row+col]==0 && upperDiagonal[n-1+col-row]==0){
                board[row][col]='Q';
                leftRow[row]=1;
                lowerDiagonal[row+col]=1;
                upperDiagonal[n-1+col-row]=1;
                solve(col+1,n,board,leftRow,upperDiagonal,lowerDiagonal,rs);
                board[row][col]='.';
                leftRow[row]=0;
                lowerDiagonal[row+col]=0;
                upperDiagonal[n-1+col-row]=0;
                

            }

        }

    } 
}

