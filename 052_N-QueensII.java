/* Analysis - DFS */

public class Solution {
    public int totalNQueens(int n) {
        List<Integer> ret = new ArrayList<>();
        int board[][] = new int[n][n];
        DFS(ret, board, 0, n);
        return ret.size();
    }

    public void DFS(List<Integer> ret, int curr[][], int i, int n) {
        if(i == n){
            ret.add(1);
            return;
        }
        
        for(int j = 0; j < n; j++){
            if(curr[i][j] != -1){
                int board[][] = new int[n][n];
                setBoard(board, curr, n, i, j);// set the non-available cells;
                board[i][j] = 1; // fill in the queen;
                DFS(ret, board, i+1, n);
            }
        }
    }
    
    public void setBoard(int board[][], int curr[][], int n, int row, int col){
        for(int i = 0 ; i < n; i++){
            System.arraycopy(curr[i], 0, board[i], 0, n);//board[r] = curr[r].clone();
        }
        
        //pre-set the column, the left down diagonal and the right down diagonal to non-available
        for(int i = row + 1, diff = 1; i < n; i++, diff++){
            board[i][col] = -1;
            if(col - diff >= 0)board[i][col-diff] = -1;
            if(col + diff < n) board[i][col+diff] = -1;
        }
    }
}
