/* Analysis
(1) find the extra tail
*/

public class Solution {
    public String shortestPalindrome(String s) {
        char [] arr = s.toCharArray();
        
        int i = 0, end = arr.length - 1, j = end;
        while(i < j){
            if(arr[i] == arr[j]){
                i++;
                j--;
            }
            else{
                i = 0;
                end --;
                j = end;
            }
        }
        
        String str = s.substring(end+1);
        StringBuffer sb = new StringBuffer(str);
        return sb.reverse() + s;
    }
}
