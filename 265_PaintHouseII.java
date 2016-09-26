/* Analysis - DP */

public class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0)
            return 0;
            
        int rows = costs.length, cols = costs[0].length;
        int min1 = 0, min2 = 0, pre = -1;//pre min
        for(int i = 0; i<rows; i++){
            int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE, idx = -1; //curr min
            for(int j = 0; j<cols; j++){
                int cost = costs[i][j] + (j == pre? min2: min1);
                if(cost < m1){
                    m2 = m1;
                    m1 = cost;
                    idx = j;
                }
                else if(cost < m2){
                    m2 = cost;
                }
            }
            min1 = m1;
            min2 = m2;
            pre = idx;
        }
        return min1;
        
    }
}
