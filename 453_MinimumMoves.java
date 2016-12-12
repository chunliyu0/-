/* Analyze
incrementing n - 1 elements by 1 == decreasing the nth element by 1
*/

public class Solution {
    public int minMoves(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        
        int min = nums[0], ret = 0;
        for(int num: nums)
            min = (min < num? min: num);
        for(int num: nums)
            ret += (num - min);
            
        return ret;
    }
}
