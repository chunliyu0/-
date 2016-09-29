/* Analysis - HashMap 
(1) get the sum and store each sum into the hashmap
(2) two possibilities: 0~i + (0~i - 0~j)
*/

public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, ret = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            
            if(sum == k)
                ret = i + 1;
            else if(map.containsKey(sum - k))
                ret = Math.max(ret, i - map.get(sum - k));
                
            if(!map.containsKey(sum))
                map.put(sum, i);
        }
        return ret;
    }
}
