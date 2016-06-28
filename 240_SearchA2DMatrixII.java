/* Analysis
(1) the right upper point is the cut-off point
(2) the left upper point and the right lower point are at the margin
(2) the whole matrix shranks to the left lower side
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int i = 0, j = cols-1; //the upper left is the smallest and the lower right is the biggest
        
        while(i <= rows - 1 || j>=0){
            if(target < matrix[i][0] || target > matrix[rows-1][j])return false;
            
            if(target == matrix[i][j])return true;
            else if(target < matrix[i][j]){
                j--;
            }
            else
                i++;
        }
        return false;
    }
}
