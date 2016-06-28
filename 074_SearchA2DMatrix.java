/* Analysis - Binary Search
row = mid/cols, col = mid%cols;
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int low = 0, high = rows*cols - 1, mid = 0;
        
        while(low <= high){
            mid = low + (high - low)/2;
            if(target == matrix[mid/cols][mid % cols]){
                return true;
            }
            else if(target < matrix[mid/cols][mid%cols])
                high = mid - 1;
            else
                low = mid + 1;
        }
        
        return false;
    }
}
