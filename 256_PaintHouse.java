/* Analysis - DP_2D
Get the total sum of the previous i housed
*/

public class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length==0 || costs[0].length == 0)return 0;
        
        int [] min = {costs[0][0], costs[0][1], costs[0][2]};
        int min0 = 0, min1 = 0, min2 = 0;
        
        for(int i = 1; i<costs.length; i++){
            min0 = Math.min(min[1], min[2]) + costs[i][0];
            min1 = Math.min(min[0], min[2]) + costs[i][1];
            min2 = Math.min(min[0], min[1]) + costs[i][2];
            
            min[0] = min0;
            min[1] = min1;
            min[2] = min2;
        }
        
        return Math.min(Math.min(min[0], min[1]), min[2]);
    }
}
