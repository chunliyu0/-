/* Analysis
Similar to the decimal to the hexadecimal problem.
*/

public class Solution {
    public String convertToTitle(int n) {
        if(n == 0)return null;
        char ch;
        String ret = "";
        
        while(n > 0){
            int rem = n%26;
            if(rem == 0)
                ch = 'Z';
            else
                ch = (char)(rem + 64);
            
            ret = ch + ret;
            n = (n-1)/26;
        }
        return ret;
    }
    
}
