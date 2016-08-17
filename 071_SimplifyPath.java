/* Analysis - Stack
chop the string by /tmp/
*/

public class Solution {
    public String simplifyPath(String path) {
        char [] arr = path.toCharArray();
        Stack<String> stk = new Stack<>();
        
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == '/'){
                String tmp = "";
                while(i+1 < arr.length && arr[i+1] != '/'){
                    tmp += arr[i+1];
                    i++;
                }
                if(tmp.equals("..")){
                    if(!stk.isEmpty()) stk.pop();
                }
                else if(!tmp.equals("") && !tmp.equals(".")){
                    stk.push(tmp);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (String s : stk) {
            sb.append("/"+s);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
