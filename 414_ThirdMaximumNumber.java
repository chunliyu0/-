public class Solution {
    public int thirdMax(int[] nums) {
        if(nums == null)return -1;
        if(nums.length == 0)return 0;
        if(nums.length == 1)return nums[0];
        if(nums.length == 2)return (nums[0] > nums[1] ? nums[0]: nums[1]);
        
        long x = Long.MIN_VALUE, y = Long.MIN_VALUE, z = Long.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == x || nums[i] == y || nums[i] == z)
                continue;
            
            if(nums[i] > x){
                z = y;
                y = x;
                x = nums[i];
            }else if(nums[i] > y){
                z = y;
                y = nums[i];
            }else if(nums[i] > z){
                z = nums[i];
            }
        }
        return (int)(z == Long.MIN_VALUE? x: z);
    }
}
