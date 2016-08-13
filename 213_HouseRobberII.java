/* Analysis - DP_1D
get hte max of [0, n-2] and [1, n-1]
*/

public class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        if(nums.length == 1)return nums[0];
        return Math.max(robBetween(nums, 0, nums.length-2), robBetween(nums, 1, nums.length-1));
    }
    
    public int robBetween(int[] nums, int start, int end) {
        if(start == end)return nums[start];
        
        int ref1 = nums[start],ref2 = Math.max(ref1, nums[start+1]), ref = ref2;
        for(int i = start+2; i<=end; i++){
            ref = Math.max(ref1 + nums[i], ref2);
            ref1 = ref2;
            ref2 = ref;
        }
        
        return ref;
    }
}
