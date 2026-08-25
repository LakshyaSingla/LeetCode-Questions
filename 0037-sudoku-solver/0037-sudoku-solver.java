class Solution {
    public void solveSudoku(char[][] board) {
        fillSudoku(board);
    }
    boolean isSafe(char num, int row, int col, char[][] board){
        for(int i = 0; i < board.length; i++){
            if(board[i][col] == num || board[row][i] == num) return false;
             
        }
        int startRow = (row / 3) * 3;
            int startCol = (col / 3) * 3;
            for(int i = startRow; i <= startRow + 2; i++){
                for(int j = startCol; j <= startCol + 2; j++){
                    if(board[i][j] == num) return false;
                }
            }
            return true;
    }
    boolean fillSudoku(char[][] board){

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j]=='.'){
                    for(char num = '1'; num <= '9'; num++){
                        if(isSafe(num, i, j, board)){
                            board[i][j] = num;
                            if(fillSudoku(board)) return true;
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