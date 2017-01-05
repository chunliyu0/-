/* start from 1 */

public class Solution {
    
    public String countAndSay(int n) {
        String start = "1";
        while(n > 1){
            int len = start.length();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < len; i++){
                int count = 1;
                char ch = start.charAt(i);
                while(i+1 < len && start.charAt(i+1) == ch){
                    count++;
                    i++;
                }
                sb.append(count + "" + ch);
            }
            
            start = sb.toString();
            n--;
        }
        
        return start;
    }
}
