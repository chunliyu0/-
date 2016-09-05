/* Analysis - Two Pointers */

public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length < 3)return 0;
        
        int ret = 0;
        Arrays.sort(nums);
        
        for(int i = 0; i<nums.length; i++){
            int start = i+1, end = nums.length - 1;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum < target){
                    ret += (end - start);//if the current sum is valid, then all the sums between start and end-- are valid
                    start++;
                }
                else 
                    end--;
            }
        }
        
        return ret;
    }
}
