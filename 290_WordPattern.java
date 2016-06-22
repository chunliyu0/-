/* Analysis - HashMap
(1) Check if each ch only has one corresponding string
(2) Check if each string only has one ch
*/

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null || str == null)return false;
        
        String [] strs = str.split(" ");
        if(strs.length!=pattern.length())return false;
        
        Map<Character, String> map = new HashMap<Character, String>();
        for(int i = 0; i<pattern.length(); i++){
            char ch = pattern.charAt(i);
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(strs[i]))
                    return false;
            }
            else{
                if(map.containsValue(strs[i]))
                    return false;
                map.put(ch,strs[i]);
            }
        }
        return true;
    }
}
