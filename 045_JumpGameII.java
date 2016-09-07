//http://www.cnblogs.com/lichen782/p/leetcode_Jump_Game_II.html
/* Analysis - Greedy */

public class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1)return 0;
      
        int ret = 0, max = 0, scope = 0;
        for(int i = 0; i < nums.length; i++) {//i == nums.legnth - 1 will never be executed
            max = (i + nums[i] > max ? i + nums[i] : max);//much faster than Math.max();
    
            if( i == scope ){//ready to jump;
                ret++;
                scope = max;
                if(scope >= nums.length - 1)return ret;
            }
        }
        return ret;
    }
}
