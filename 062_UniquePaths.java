/* Analysis - DP [Bottom up]

public class Solution {
    public int uniquePaths(int m, int n) {
        int [] sum = new int[n];
        
        //initialization, deal with the first row
        for(int j = 0; j<n; j++)
            sum[j] = 1;
        
        for(int i = 1; i<m; i++){
            for(int j = 1; j < n; j++)
                sum[j] = sum[j] + sum[j-1];
        }
        
        return sum[n - 1];
    }
}
