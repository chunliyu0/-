/* Analysis
Using a hashmap to save the first array, value is the number of num,
when the elements in the second array are also contained in the hashmap, which means they are intersections,
the corresponding value is decreased by 1, and the num is put to the list;
finally, convert the list to the int[].
*/

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //Base cases
        if(nums1 == null || nums2 == null)return null;
        
        //save the 1st array
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num: nums1){
            if(!map.containsKey(num))
                map.put(num, 1);
            else
                map.put(num, map.get(num)+1);
        }
        
        //find the intersection in the 2nd array
        List<Integer> list=new ArrayList<Integer>();  
        for(int num: nums2){
            if(map.containsKey(num) && map.get(num)>0){
                list.add(num);
                map.put(num, map.get(num)-1);
            }
        }
        
        //transform the result set to int array (note: not Integer array)
        int[] ret = new int[list.size()];       
        Iterator<Integer> iter = list.iterator();
        for (int i=0; iter.hasNext(); i++) {       
            ret[i] = iter.next();                
        }                                        
        return ret;
    }
}
