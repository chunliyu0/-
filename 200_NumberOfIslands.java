/* Analysis - DFS */

public class Solution {
    
    boolean [][] visited; 
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)return 0;
        
        int ret = 0;
        int rows = grid.length, cols = grid[0].length;
        visited = new boolean[rows][cols];
        
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j] == '0' || visited[i][j])continue;
                dfs(grid, i,j);
                ret++;
            }
        }
        
        return ret;
    }
    
    public void dfs(char[][] grid, int i, int j){
        if(i == grid.length || i == -1 || j == grid[0].length || j == -1)return;//over flow
        if(grid[i][j] == '0' || visited[i][j])return;
        
        visited[i][j] = true;
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}
