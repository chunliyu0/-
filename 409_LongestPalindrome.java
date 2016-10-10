/* Analysis
(1) count the total number of even ones
(2) plus one if odd one exist
*/

public class Solution {
    public int longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int ret = 0;
        boolean isOdd = false;
        
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else
                map.put(arr[i], 1);
        }
        
        for (int val : map.values()) {
            if(!isOdd && (val & 1) == 1) // an odd number
                isOdd = true;
            ret += (val / 2);
        }
        
        return ret*2 + (isOdd?1:0);
    }
}
