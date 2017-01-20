public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int loc = -1, max = 0, left = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                left = loc + 1;
                loc = i;
            }
            max = Math.max(max, i - left + 1);
        }
        
        return max;
    }
}
