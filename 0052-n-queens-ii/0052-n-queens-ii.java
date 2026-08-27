class Solution {
    boolean isValid(int row, int col, List<String> board){
        int r = row;
        int c = col;
        while(r >= 0){
            if(board.get(r).charAt(c) == 'Q'){
                return false;
            }
            r--;
        }
        r = row;
        while(r >= 0 && c >= 0){
            if(board.get(r).charAt(c) == 'Q') return false;
            r--;
            c--;
        }
        r = row;
        c = col;
        while(r >= 0 && c < board.size()){
            if(board.get(r).charAt(c) == 'Q') return false;
            r--;
            c++;
        }
        return true;
    }
    int PossibleBoards(int row, int n, List<String> board){
        int count = 0;
        if(row == n){
            
            return 1;
        }
        for(int col = 0; col < n; col++){
            if(isValid(row, col, board)){
                char[] arr = board.get(row).toCharArray();
                arr[col] = 'Q';
                board.set(row, new String(arr));
                count+=  PossibleBoards(row + 1, n, board);
                arr[col] = '.';
                board.set(row, new String(arr));
            }
        }
        return count;
    }
    public int totalNQueens(int n) {
        List<String> board = new ArrayList<>();
        String temp = "";
        for(int i = 0; i < n; i++){
            temp+='.';
        }
        for(int i = 0; i < n; i++){
            board.add(temp);
        }
        return PossibleBoards(0, n, board);
        
    }
}