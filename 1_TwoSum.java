//Use a hashmap to save all the nums

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int i;
        
        //the key cannot be repeated in a map. the first key will be replaced when it appears the second time
        for(i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(i=0;i<nums.length;i++){
            if(map.get(target-nums[i])!=null&&map.get(target-nums[i])!=i){
                result[0] = i+1;
                result[1] = map.get(target-nums[i])+1;
                break;
            }
        }
       return result;
    }
}
