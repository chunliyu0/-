/* Analysis - DP_1D */

public class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        if(nums.length == 1)return nums[0];
        
        int [] ref = new int[nums.length];
        ref[0] = nums[0];
        ref[1] = Math.max(nums[1], ref[0]);
        
        for(int i = 2; i<nums.length; i++){
            ref[i] = Math.max(ref[i-2] + nums[i], ref[i-1]);
        }
        
        return ref[nums.length-1];
    }
}
