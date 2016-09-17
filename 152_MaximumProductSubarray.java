/* Analysis - DP[Maximum]
(1) be careful with the negative ones
(2) be careful with the 0s
(3) similar to the Longest valid Parenthesis
(4) currMax = Math.max(nums[i], nums[i] * preMax, nums[i] * preMin);
*/

public class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        
        int ret = nums[0], currMax = nums[0], currMin = nums[0];
        for(int i = 1; i < nums.length; i++){
            int preMax = currMax, preMin = currMin;
            currMax = Math.max(nums[i], Math.max(preMax * nums[i], preMin * nums[i])); // -2, 1
            currMin = Math.min(nums[i], Math.min(preMax * nums[i], preMin * nums[i])); // 1, -2

            if(currMax > ret)
                ret = currMax;
        }
        
        return ret;
    }
}
