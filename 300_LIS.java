/* Analysis - DP */

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int [] ref = new int[nums.length];
        
        for(int i = 0; i<nums.length; i++){
            int max = 0;
            for(int j = i-1; j >= 0; j--){
                if(nums[j] < nums[i] && ref[j] > max){
                    max = ref[j];
                }
            }
            ref[i] = max + 1;
        }
        
        int lis = 0;
        for(int i = 0; i<ref.length; i++){
            if(ref[i] > lis)
                lis = ref[i];
        }
        return lis;
    }
}
