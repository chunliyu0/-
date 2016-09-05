/* Analysis - two pointers */

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>(); 
        if(nums==null || nums.length < 3)
            return ret;
        
        Arrays.sort(nums);
        if(nums[0] > 0 || nums[nums.length - 1] < 0)
            return ret;
        
        for(int i = 0; i < nums.length && nums[i] <= 0; i++){
            int start = i+1, end = nums.length - 1;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(nums[i] + nums[start] + nums[end] == 0){
                    List<Integer> tmp = new ArrayList(Arrays.asList(nums[i], nums[start], nums[end]));
                    ret.add(tmp);
                    int val = nums[start];
                    while(start < nums.length && nums[start] == val) start++;//avoid repetion
                    
                    val = nums[end];
                    while(end > start && nums[end] == val) end--;//avoid repetion
                }
                else if(nums[i] + nums[start] + nums[end] < 0)
                    start++;
                else
                    end--;
            }
            
            while(i+1 < nums.length && nums[i+1] == nums[i])//avoid repetion
                i++;
        }
        return ret;
    }
}
