/* Analysis
 Check Character by Character 
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length == 0)return "";
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<strs.length; i++){
            if(strs[i].length() < min)min = strs[i].length();
        }
        
        int idx = 0;
        while(idx < min){
            char ch = strs[0].charAt(idx);
            for(int i = 1; i<strs.length; i++){
                if(strs[i].charAt(idx)!=ch)
                    return strs[i].substring(0,idx);
            }
            idx++;
        }
        return strs[0].substring(0,idx);
    }
}
