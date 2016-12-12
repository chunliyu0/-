/* Analysis
find the medium one
*/

public class Solution {
    public int minMoves2(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        Arrays.sort(nums);
        int n = nums.length, mid = nums[n/2], ret = 0;
        
        for(int num: nums){
            ret += Math.abs(num - mid);
        }
        
        return ret;
    }
}
