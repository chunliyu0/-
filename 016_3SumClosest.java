/* Analysis - Two Pointers */

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3)return Integer.MAX_VALUE;
        
        Arrays.sort(nums);//System.out.println(Arrays.toString(nums));
        int min = Integer.MAX_VALUE, ret = 0;
        for(int i = 0; i<nums.length-2; i++){
            int start = i+1, end = nums.length - 1;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(Math.abs(sum-target) < min){
                    min = Math.abs(sum-target);
                    ret = sum;
                }
                
                if(sum == target)
                    return target;
                else if(sum > target)
                    end--;
                else
                    start++;
            }
        }
        return ret;
    }
}
