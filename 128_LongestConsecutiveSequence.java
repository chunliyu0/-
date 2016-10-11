/* Analysis 
(1) Each time we just record the left border and the right border
(2) Do as like it is a Ice-Suger gourd
*/

public class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num: nums){
            if(map.containsKey(num))continue;
                
            int left = (map.containsKey(num - 1) ? map.get(num - 1): 0);
            int right = (map.containsKey(num + 1) ? map.get(num + 1): 0);
            int val = 1 + left + right;
            map.put(num, val);
            if(val > maxLen)
                maxLen = val;
            
            map.put(num - left, val);
            map.put(num + right, val);
        }
        
        return maxLen;
    }
}

