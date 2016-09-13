/* Analysis 
Compare character by character
*/

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        if(m > n)return isOneEditDistance(t, s);//make sure s is not longer than t
        
        if(n - m > 1)return false;

        for(int i = 0; i < m; i++){
            if(s.charAt(i) ==  t.charAt(i))continue;
            
            if(s.substring(i).equals(t.substring(i+1)) || s.substring(i+1).equals(t.substring(i+1)))
                return true;
            else
                return false;
        }
        return !(m == n);
    }
}
