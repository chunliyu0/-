/* Analysis - DFS 
(1) keep in mind that list.remove(char) by index while list.remove(Character) by value
*/

public class Solution {
    HashMap<Integer, List<Character>> rowMap = new HashMap<>();
    HashMap<Integer, List<Character>> colMap = new HashMap<>();
    HashMap<Integer, List<Character>> squareMap = new HashMap<>();
        
    public void solveSudoku(char[][] board) {
        if(board.length == 0 || board[0].length == 0)return;
        
        for(int i = 0; i<9; i++){
            rowMap.put(i, new ArrayList<Character>());
            colMap.put(i, new ArrayList<Character>());
            squareMap.put(i, new ArrayList<Character>());
        }
        for(int i = 0; i<9; i++){
            for(int j= 0; j< 9; j++){
                if(board[i][j] == '.')continue;

                rowMap.get(i).add(board[i][j]);//fill in the rowmap
                colMap.get(j).add(board[i][j]);//fill in colmap
                squareMap.get(i/3*3 + j/3).add(board[i][j]);//fill in squaremap
            }
        }
        
        dfs(board, 0, 0);
    }
    
    public boolean dfs(char [][] board,  int row, int col){
        if(row == 9)
            return true;
        if(col == 9)
            return dfs(board, row + 1, 0);
        if(board[row][col] != '.')
            return dfs(board, row, col + 1);
            
        for(char val = '1'; val <= '9'; val++){
            if(rowMap.get(row).contains(val)||colMap.get(col).contains(val)||squareMap.get(row/3*3 + col/3).contains(val))continue;
            
            board[row][col] = val;
            rowMap.get(row).add(val);
            colMap.get(col).add(val);
            squareMap.get(row/3*3 + col/3).add(val);
            
            if(!dfs(board, row, col + 1))
                return true;
            else{
                board[row][col] = '.';
                rowMap.get(row).remove((Character)val);
                colMap.get(col).remove((Character)val);
                squareMap.get(row/3*3 + col/3).remove((Character)val);
            }
        }
        return false;      
    }
}
     
