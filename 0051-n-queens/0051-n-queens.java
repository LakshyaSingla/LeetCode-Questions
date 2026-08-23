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
            if(board.get(r).charAt(c) == 'Q'){
                return false;
            }
            r--;
            c--;
        }
        r = row;
        c=col;
        while(r >= 0 && c < board.size()){
            if(board.get(r).charAt(c) == 'Q'){
                return false;
            }
            r--;
            c++;
        }
        return true;
    }

    void Queen(int row, List<String> board, List<List<String>> ans){
        if(row == board.size()){
            ans.add(new ArrayList<>(board));
            return;
        }

        for(int col = 0; col < board.size(); col++){
            if(isValid(row, col, board)){
                char[] arr = board.get(row).toCharArray();
                arr[col] = 'Q';
                board.set(row, new String(arr));
                Queen(row + 1, board, ans);
                arr[col] = '.';
                board.set(row, new String(arr));
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        String temp = "";
        for(int i = 0; i < n; i++){
            temp+=".";
        }
        for(int i = 0; i < n; i++){
            board.add(temp);
        }
        Queen(0, board, ans);
        return ans;
    }
}