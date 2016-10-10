/* Analysis - HashMap and Sliding window*/

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int len = s.length(), n = words.length, m = words[0].length();
        List<Integer> ret = new ArrayList<>();
        if(len < m*n)return ret;
        
        Map<String, Integer> refMap = new HashMap<>();
        //initialization of the HashMap
        for(String str: words){
            if(!refMap.containsKey(str))
                refMap.put(str, 1);
            else
                refMap.put(str, refMap.get(str)+1);
        }
        
        // go through the string for m rounds
        for(int i = 0; i < m; i++){
            int count = 0, start = i; 
            Map<String, Integer>  map = new HashMap<>();
            Map<Integer, String> loc = new HashMap<>();
            for(int j = i; j <= len - m; j += m){
                //if(start + m * n > len)break; // check if it is the last possible one
                
                String str = s.substring(j, j + m);
                //System.out.println(str);
                if(!refMap.containsKey(str)){ // if the new string is not in the dictionary, restart
                    count = 0;
                    start = j + m;
                    map.clear();
                }
                else{
                    loc.put(j, str);
                    if(map.containsKey(str) && map.get(str) == refMap.get(str)){//extra counts 
                        while(start <= j){
                            String tmp = loc.get(start);
                            if(tmp.equals(str))break;
                            
                            map.put(tmp, map.get(tmp) - 1);
                            count--;
                            start += m;
                        }
                        start += m;
                    }
                    else{
                        map.put(str, map.containsKey(str) ? map.get(str) + 1: 1);
                        count++;
                    }
                } 
                
                if(count == n){
                    ret.add(start);
                    String tmp = loc.get(start);
                    map.put(tmp, map.get(tmp) - 1);
                    count--;
                    start += m;
                }
                    
            }
        }
        
        return ret;
    }
}
