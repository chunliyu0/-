/* Analysis 
Each time move one round
*/

public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 1)return;
        
        int n  = matrix.length;
        
        //just need to deal with the 1/4;
        for(int i = 0; i< (n + 1)/2 ;i++)
            for(int j = 0; j<n/2; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;
            }
    }
}
