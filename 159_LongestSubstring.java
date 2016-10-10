/* Analysis - hashMap + sliding window */

public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char [] arr = s.toCharArray();
        int maxLen = 0, i = 0;
        HashMap<Character, Integer> map = new HashMap<>(); //only save the newest one
        
        for(int j = 0; j < arr.length; j++){
            map.put(arr[j], j);
            while(map.size() > 2){
                if(map.get(arr[i]) == i) //there is only one arr[i]
                    map.remove(arr[i]);
                i++;
            }
            
            if(j - i + 1 > maxLen)
                maxLen = j - i + 1;
        }
    
        return maxLen;
    }
}
