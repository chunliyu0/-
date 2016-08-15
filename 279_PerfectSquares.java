/* Analysis - DP_1D
(1) For each number, consider all the combinations of different squares
*/

public class Solution {
    public int numSquares(int n) {
        int [] ref = new int[n+1];
        for(int i = 1; i<=n; i++){//leave ref[0] == 0
            ref[i] = n+1;
        }
        
        for(int i = 1; i <= n; i++){
            if(ref[i] <= 2)
                continue;
            for(int j = 1; j*j <= i; j++){
                ref[i] = Math.min(ref[i], 1+ref[i-j*j]);//when we calculate i, it means i-1 has been calculated
            }
        }
            
        return ref[n];
    }
}
