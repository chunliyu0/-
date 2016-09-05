/* Analysis - Two Pointer
(1) Be careful the sum is the target not the 0
*/

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4) return ret;
        
        Arrays.sort(nums);
        
        for(int i = 0; i <= nums.length - 4; i++){
            for(int j = i+1; j <= nums.length - 3; j++){
                
                int start = j+1, end = nums.length - 1;
                while(start < end){
                    if(nums[i] + nums[j] + nums[start] + nums[end] == target){
                        List<Integer> tmp = new ArrayList(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        ret.add(tmp);
                        
                        int val = nums[start];
                        while(start < nums.length - 1 && nums[start] == val) start++;//avoid repetion
                        
                        val = nums[end];
                        while(end > start && nums[end] == val) end--;//avoid repetion
                    }
                    else if(nums[i] + nums[j] + nums[start] + nums[end] < target)
                        start++;
                    else
                        end--;
                }
                
                while(j+1 <= nums.length - 3 && nums[j+1] == nums[j])j++;
            }
            while(i+1 <= nums.length - 4 && nums[i+1] == nums[i])i++;
        }
        
        return ret;
        
    }
}
