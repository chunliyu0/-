/* Analysis - Sliding window 
Each time we count in a new num[i], sum will always be the smallest window
*/

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        int sum = 0, start = 0, ret = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            while(sum >= s){
                ret = Math.min(ret, i- start + 1);
                sum -= nums[start];
                start++;
            }
        }
        return ret == Integer.MAX_VALUE ? 0: ret;
    }
}
