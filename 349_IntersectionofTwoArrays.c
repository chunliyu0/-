/* Analysis
Using a hashmap to save the first array with the value 0,
when the elements in the second array are also contained in the hashmap, which means they are intersections,
the corresponding value is reset to 1;
finally, the entries with 1s are the result.
*/

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //base cases
        if(nums1 == null || nums2 == null)return null;
        
        //save the 1st array
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num: nums1){
            if(!map.containsKey(num)){
                map.put(num,0);
            }
        }
        
        //find the intersection in the 2nd array
        for(int num: nums2){
            if(map.containsKey(num)){
                map.put(num, 1);
            }
        }
        
        //get rid of the 0 entries
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<Integer, Integer> entry= it.next();
            if(entry.getValue()==0)
                it.remove();
        }
        
        //transform the result set to int array (note: not Integer array)
        Object[] obj = map.keySet().toArray();  
        int temp[] = new int[obj.length];  
        for (int i = 0; i < obj.length; i++) {  
            temp[i] = (int) obj[i];
        }
        return temp;
    }
}
