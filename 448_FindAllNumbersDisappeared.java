public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        int n = nums.length;
        
        for(int i = 0; i < n; i++){
            int idx = (nums[i] - 1) % n;
            nums[idx] += n;
        }
            
        for(int i = 0; i < n; i++){
            if(nums[i] <= n)
                ret.add(i + 1);
        }
        
        return ret;
    }
}
