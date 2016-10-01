/* Analysis - Two Pointers 
(1) create a hashmap for each character in t and count their frequency in t as the value of hashmap.
(2) Checking from the leftmost index of the window and to see if it belongs to t. 
    If the character at leftmost index does not belong to t, remove this leftmost value and update our window
    If the character indeed exists in t, we still remove it, in the next round, increase the right and expect the removed character. 
*/

public class Solution {
    public String minWindow(String s, String t) {
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0, start = 0, window = Integer.MAX_VALUE;
        
        //fill up the map based on String t
        for(char ch: arrT){
            if(map.containsKey(ch))
                map.put(ch, map.get(ch)+1);
            else
                map.put(ch, 1);
        }
        
        int j = 0;
        for(int i = 0; i < arrS.length; i++){
            // find the window
            if(map.containsKey(arrS[i])){
                map.put(arrS[i], map.get(arrS[i])-1);
                if(map.get(arrS[i]) >= 0){
                    count++;
                }
            }
            
            // shrink the size of the window
            while(count == arrT.length){// update the left border
                if(map.containsKey(arrS[j])){
                    map.put(arrS[j], map.get(arrS[j]) + 1);
                    if(map.get(arrS[j]) > 0){
                        count--;
                        if(i - j + 1 < window){
                            window = i - j + 1;
                            start = j;
                        }
                    }
                }
                j++;
            }
        }
        
        return window == Integer.MAX_VALUE ? "": s.substring(start, start + window);
    }
}
