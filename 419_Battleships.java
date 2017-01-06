/*
(1) the battleship is always valid
(2) just count the head
*/

public class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length;
        int cnt = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'X' && (i == 0 || board[i-1][j] == '.') && (j == 0 || board[i][j-1] == '.'))
                    cnt ++;
            }
        }
        
        return cnt;
    }
}
