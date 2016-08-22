/* Analysis - Stack */

public class Solution {
    public boolean isValid(String s) {
        if(s==null)return true;
        if(s.length()%2!=0)return false;
        
        char [] arr = s.toCharArray();
        Stack<Character> stk = new Stack<>();
        
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == '(' || arr[i] == '[' || arr[i] == '{')
                stk.push(arr[i]);
            else {
                if(stk.isEmpty())return false;
                
                if(arr[i] == ')'){
                    if(stk.pop() != '(')return false;}
                else if(arr[i] == ']'){
                    if(stk.pop() != '[')return false;}
                else if(arr[i] == '}'){
                    if(stk.pop() != '{')return false;}
            }
        }
        
        return stk.isEmpty();
    }
}
