/* Analysis - DP[bottom up] */

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int [] ref= new int[target + 1];
        ref[0] = 1;
        for(int i = 1; i<= target; i++){
            for( int j = 0; j<nums.length; j++){//put nums[j] as the head
                if( nums[j] <= i )
                    ref[i] += ref[i - nums[j]]; 
            }
        }
        return ref[target];
    }
}
