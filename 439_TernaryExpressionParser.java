/* Analysis - Stack */

public class Solution {
    public String parseTernary(String expression) {
        Stack<Character> stk = new Stack<>();
        int n = expression.length();
        
        for(int i = n - 1; i >= 0; i--){
            char ch = expression.charAt(i);
            if(!stk.isEmpty() && stk.peek() == '?'){
                stk.pop(); // pop out the '?'
                char first = stk.pop(); 
                stk.pop(); // pop out the ':'
                char second = stk.pop();
                
                if(ch == 'T')
                    stk.push(first);
                else
                    stk.push(second);
            }
            else
                stk.push(ch);
        }
        
        return "" + stk.pop();
    }
}
