/* Analysis
Using treeMap to sort the array automatically
*/

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        
        for(int num: nums){
            if(!map.containsKey(num))
                map.put(num, 1);
            else
                map.put(num, map.get(num)+1);
        }
        
        int sum = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            sum+= entry.getValue();
            if(sum>=nums.length-k+1)
                return entry.getKey();
        }
        return -1;
    }
}
