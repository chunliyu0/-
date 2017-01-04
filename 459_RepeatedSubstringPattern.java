public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        int n = str.length();
        
        for(int i = n/2; i >= 1; i--){
            if(n % i != 0) continue;
            
            String patt = str.substring(0, i);
            int j = i;
            while(j < n){
                String sub = str.substring(j, j+i);
                if(!sub.equals(patt))
                    break;
                j += i;
            }
            if(j == n)
                return true;
        }
        
        return false;
    }
}
