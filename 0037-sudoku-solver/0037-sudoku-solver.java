class Solution {
    public void solveSudoku(char[][] board) {
        SudokuSolver(board);
    }
    boolean isSafe(int num, char[][] board, int row, int col){
        int r = row;
        int c = col;

        for(int i = 0; i < 9; i++){
            if(board[i][c] == num || board[r][i] == num) return false;
        }
        int startRow = (r / 3 ) * 3;
        int startCol = (c / 3) * 3;
        for(int i = startRow; i <= startRow + 2; i++){
            for(int j = startCol; j <= startCol + 2; j++){
                if(board[i][j] == num) return false;
            }
        }
        return true;
    }
    boolean SudokuSolver(char[][] board){
        int n = 9;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isSafe(c, board, i, j)){
                            board[i][j] = c;
                            if(SudokuSolver(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;

    }
}