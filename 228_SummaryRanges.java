/* Analysis
(1) using start to record the start point of the new range
*/

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<String>();
        if(nums == null || nums.length == 0){
            return ret;
        }
        if(nums.length == 1){
            ret.add(""+nums[0]);
            return ret;
        }
        int start = 0;
        
        for(int i = 1; i<nums.length; i++){
            if(nums[i]-1>nums[i-1]){//deal with overflow
                String str = "" + nums[start];
                if(i-1 > start)
                    str += "->" + nums[i-1];
                ret.add(str);
                start = i;
            }
        }
        
        //deal with the last range
        String str = "" + nums[start];
        if(nums.length -1 > start)
            str += "->" + nums[nums.length -1];
        ret.add(str);
        
        return ret;
    }
}
