//Hashmap + Selection Sort

public class Solution {
	public static int getMax(Map<Integer, Integer> map){
        int maxVal = 0, maxKey = -1;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(maxVal < entry.getValue()){
            	maxVal = entry.getValue();
            	maxKey = entry.getKey();
            }
        }
        return maxKey;
    } 
	
	public static List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> list = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i: nums){
            if(!map.containsKey(i))
                map.put(i,1);
            else
                map.put(i,map.get(i)+1);
        }
        
        while(k!=0){
        	int num = getMax(map);
        	list.add(num);
        	map.remove(num);
        	k--;
        }
        
		return list;
    }
}
