/* Analysis - DP[Bottom up] */

public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0)return 0;
        
        int rows = grid.length, cols = grid[0].length;
        int []sum = new int[cols];
        
        //initialization - deal with the first row
        sum[0] = grid[0][0];
        for(int j = 1; j < cols; j++)
            sum[j] = sum[j-1] + grid[0][j];
            
        for(int i = 1; i<rows; i++){
            sum[0] += grid[i][0];
            for(int j = 1; j<cols; j++){
                sum[j] = Math.min(sum[j-1], sum[j]) + grid[i][j];
            }
        }
        
        return sum[cols-1];
    }
}
