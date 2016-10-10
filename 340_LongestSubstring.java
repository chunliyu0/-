/* Analysis - HashMap + sliding window */

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] arr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, maxLen = 0;
        
        for(int j = 0; j < arr.length; j++){
            map.put(arr[j], j);
            while(map.size() > k){
                if(map.get(arr[i]) == i)
                    map.remove(arr[i]);
                i++;
            }
            if(j - i + 1 > maxLen)
                maxLen = j - i + 1;
        }
    
        return maxLen;
    }
}
