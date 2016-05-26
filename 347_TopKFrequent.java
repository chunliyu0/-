/* Analysis
Using HashMap and Comparator
*/

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums==null)return null;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num: nums){
            if(!map.containsKey(num))
                map.put(num, 1);
            else
                map.put(num, map.get(num)+1);
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        
        List<Integer> ret = new ArrayList<Integer>();
        int i =0;
        for(Map.Entry<Integer, Integer> entry: list){
            i++;
            if(i<=k){
                ret.add(entry.getKey().intValue());
            }
            else
                break;
        }
        return ret;
    }
}
