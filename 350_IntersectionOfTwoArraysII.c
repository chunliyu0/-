public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null)return null;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num: nums1){
            if(!map.containsKey(num))
                map.put(num, 1);
            else
                map.put(num, map.get(num)+1);
        }
        
        List<Integer> list=new ArrayList<Integer>();  
        for(int num: nums2){
            if(map.containsKey(num) && map.get(num)>0){
                list.add(num);
                map.put(num, map.get(num)-1);
            }
        }
        
        int[] ret = new int[list.size()];       
        Iterator<Integer> iter = list.iterator();
        for (int i=0; iter.hasNext(); i++) {       
            ret[i] = iter.next();                
        }                                        
        return ret;
    }
}
