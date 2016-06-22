/* Analysis - Hashmap
(1) Check if each ch1 match the same ch2;
(2) Check if each ch2 only has one ch1;
*/

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s==null||t==null||s.length()!=t.length())return false;
        
        Map<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0; i<s.length();i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if(map.containsKey(ch1)){
                if(map.get(ch1)!=ch2)
                    return false;//(1)
            }
            else{
                if(map.containsValue(ch2))
                    return false;//(2)
                map.put(ch1,ch2);//!!!
            }
        }
        return true;
    }
}
