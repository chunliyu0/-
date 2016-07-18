/* Analysis
check one by one
*/

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ret = new ArrayList<String>();
        if(nums==null)return ret;
        if(nums.length == 0){
            String tmp = "";
            tmp += lower;
            if(lower < upper)
                tmp += "->" + upper;
            ret.add(tmp);
            return ret;
        }
        
        //deal with the first gap
        if(nums[0] > lower){
            String tmp = "";
            tmp += lower;
            if(lower+1 < nums[0])
                tmp += "->" + (nums[0] - 1);
            ret.add(tmp);
        }
        
        //deal with the array part
        for(int i = 1; i<nums.length; i++){
            if(nums[i] - nums[i-1] > 1){
                String tmp = "" + (nums[i-1] + 1);
                if(nums[i] - nums[i-1] > 2)
                    tmp += "->" + (nums[i] - 1);
                ret.add(tmp);
            }
        }
        
        //deal with the last gap
        if(nums[nums.length-1] < upper){
            String tmp = "";
            tmp += (nums[nums.length-1] + 1);
            if(nums[nums.length-1] + 1 < upper)
                tmp += "->" + upper;
            ret.add(tmp);
        }
        
        return ret;
    }
}
