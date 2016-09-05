/* Analysis - Stack */

public class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0)return "";
        
        Stack<String> stk = new Stack<>();
        char [] arr = s.toCharArray();
        for(int i = 0; i<arr.length; i++){
            if(arr[i] >= '0' && arr[i] <= '9'){
                int num = arr[i] - '0';
                while(arr[i+1] >= '0' && arr[i+1] <= '9'){
                    num = num* 10 + (arr[i+1] - '0');
                    i++;
                }
                stk.push("" + num);
            }
            else if(arr[i] == ']'){
                
                //get the current root string
                String tmp = new String();
                while(!stk.isEmpty() && !stk.peek().equals("["))
                    tmp = stk.pop() + tmp;
                if(!stk.isEmpty())
                    stk.pop();//pop out the '['
                
                //decode the root string;
                int num = 0;
                if(!stk.isEmpty())
                    num = Integer.valueOf(stk.pop());
                stk.push(decode(tmp, num));
            }
            else
                stk.push(""+arr[i]);
        }
        
        String ret = new String();
        while(!stk.isEmpty())
            ret = stk.pop() + ret;
        return ret;
    }
    
    public String decode(String str, int n){
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.append(str);
            n--;
        }
        return sb.toString();
    }
}
