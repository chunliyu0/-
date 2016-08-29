/* Analysis - Binary Search 
(1) It's a n*n 2D array, the element in it can be repeated
(2) Matrix[0][0] is the smallest while matrix[0][0] is the largest;
    assume the mid is the kth, so we need to check if the count less than mid is equal to k
(3) to get the count of elements less than mid, we can make use of the ascending order of the 2D array
*/

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, low = matrix[0][0], high = matrix[n-1][n-1];
        
        while(low < high){
            int mid = low + (high - low)/2;
            if(k <= getCount(matrix, n, mid)){//even if k < count, k may be the mid because the repetions
                high = mid;
            }
            else if(k > getCount(matrix, n, mid)){
                low = mid + 1;
            }
        }
        return low;
    }
    
    public int getCount(int[][] matrix, int n, int mid){
        int i = n-1, j = 0, count = 0; //start from the left corner
        while(i >= 0 && j <= n-1){
            if(matrix[i][j] <= mid){
                count += (i + 1);
                j++;//move right;
            }
            else
                i--;
        }
        return count;
    }
}
