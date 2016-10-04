/* Analysis - DP_Maximum */

public class Solution {
    public boolean canCross(int[] stones) {
        if(stones == null || stones.length < 2) return true;
        if(stones[1]!=1) return false; //the second stone must be 1
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] max_arr = new int[stones.length];
        max_arr[1] = 1;
        map.put(1, new ArrayList<>(Arrays.asList(1)));
        
        for(int i = 1; i < stones.length; i++){
            if(max_arr[i] == 0) continue; // the current stone cannot be reached;
            List<Integer> list = map.get(i);
            for(int j = i + 1; j < stones.length; j++){
                int gap = stones[j] - stones[i];
                if(gap > max_arr[i] + 1) break;
                
                if(list.contains(gap + 1) || list.contains(gap) || list.contains(gap - 1)){
                    if(map.containsKey(j))
                            map.get(j).add(gap);
                        else
                            map.put(j, new ArrayList<>(Arrays.asList(gap)));
                         
                        if(max_arr[j] == 0)
                            max_arr[j] = gap;
                }
            }
        }
        
        return max_arr[max_arr.length - 1] > 0;
    }
}
