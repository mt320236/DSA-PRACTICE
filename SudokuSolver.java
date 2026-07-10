/*
Approach:
1. Traverse the Sudoku board to find the first empty cell ('.').
2. Try placing digits from '1' to '9' in that cell.
3. Before placing a digit, check whether it is valid:
   - The digit should not exist in the same row.
   - The digit should not exist in the same column.
   - The digit should not exist in the corresponding 3x3 subgrid.
4. If the placement is valid, place the digit and recursively solve the remaining board.
5. If recursion returns true, the Sudoku is solved.
6. Otherwise, backtrack by removing the digit and try the next possible value.
7. If no digit can be placed, return false to backtrack further.

Time Complexity: O(9^(N*N)) in the worst case
Space Complexity: O(N*N) due to recursion stack (worst case)
*/


class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
        
    }
    public boolean isValid(char [][] board,int col,int row, char c){
        for(int i=0;i<9;i++){
            if(board[row][i]==c){
                return false;
            }
            if(board[i][col]==c){
                return false;
            }

        }
        int startRow=(row/3)*3;
        int startCol=(col/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[startRow+i][startCol+j]==c){
                    return false;
                }
            }
        }
        return true;





    }
    public boolean solve(char [][] board){
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(board[row][col]=='.'){
                    for(char c='1';c<='9';c++){
                     if(isValid(board,col,row,c)){
                         board[row][col]=c;
                         if(solve(board)){
                            return true;
                         }
                         else{
                            board[row][col]='.';
                         }

                        }

                    }
                    return false;

                }
                
                 

            }

            
           
        }
        return true;

    }
}
