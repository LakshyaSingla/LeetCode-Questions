class Solution {
    public void solveSudoku(char[][] board) {
        fillSudoku(board);
    }
    boolean fillSudoku(char[][] board){

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char k = '1'; k <= '9'; k++){
                        if(isSafe(k, board, i, j)){
                            board[i][j] = k;
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
    boolean isSafe(int num, char[][] board, int row, int col){
        for(int i = 0; i < 9; i++){
            if(board[row][i] == num || board[i][col] == num) return false;
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
}