/* Anlaysis - Greedy */

public class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length <= 1)return true;
        
        int maxLeap = nums[0];
        for(int i = 0; i < nums.length; i++){
            maxLeap = Math.max(i + nums[i], maxLeap);
            if(maxLeap >= nums.length - 1)return true;

            if(i == maxLeap)break;
        }
        
        return false;
    }
}
