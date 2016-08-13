/* Analysis
Check for rows, columns and squares respectively, pay attention to the values of i and j when solving with squares
*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0].length==0)return false;
        
        int rows = board.length, cols = board[0].length;
        if(rows!=9 || cols!=9)return false;
        
        //check the rows
        for(int i = 0; i<9; i++){
            int [] map = new int[9];
            for(int j = 0; j<9; j++){
                char val = board[i][j];
                if(val == '.')continue;
                if(map[val -'1']==1)
                    return false;
                else
                    map[val -'1']=1;
            }
        }
        
        //check the cols
        for(int j = 0; j<9; j++){
            int [] map = new int[9];
            for(int i = 0; i<9; i++){
                char val = board[i][j];
                if(val == '.')continue;
                if(map[val -'1']==1)
                    return false;
                else
                    map[val -'1']=1;
            }
        }
        
        //check for squares
        for(int n = 0; n<9; n++){//there are nine squares;
            int [] map = new int[9];
            for(int i = n/3*3; i < n/3*3 + 3; i++){
                for(int j = n%3*3; j < n%3*3 + 3; j++){
                    char val = board[i][j];
                    if(val == '.')continue;
                    if(map[val -'1']==1)
                        return false;
                    else
                        map[val -'1']=1;
                }
            }
        }
        
        return true;
    }
}
