public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        int n = nums.length;
        
        for(int i = 0; i < n; i++){
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] < 0)
                ret.add(idx + 1);
            nums[idx] = -nums[idx];
        }
        
        return ret;
    }
}
