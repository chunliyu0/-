/* Analysis - DP [Bottom up] */

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0].length==0)return 0;
        if(obstacleGrid[0][0]==1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1)return 0;
        
        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
        int [] sum = new int[cols];
        
        //initialization - the first row
        sum[0] = 1;
        for(int j=1; j<cols; j++){
            if(obstacleGrid[0][j]==1)sum[j] = 0;
            else sum[j] = sum[j-1];
        }
        
        for(int i = 1; i<rows; i++){
            if(obstacleGrid[i][0]==1)sum[0] = 0;//set as unavailable
            for(int j = 1; j<cols; j++){
                if(obstacleGrid[i][j]==1)
                    sum[j] = 0;
                else
                    sum[j] = sum[j] + sum[j-1];
            }
        }
        
        return sum[cols-1];
    }
}
