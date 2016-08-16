//385. Mini Parser

/* Analysis 
(1) using stack the store the control sign for each number, the total control sign for 2 in 1+(4-(5-2)) is +;
(2) assuming the initial control sign for each number is +;
(3) the result is to add each number with its control sign one by one.
*/

public class Solution {
    public int calculate(String s) {
        if(s==null)return 0;
        
        Stack stk = new Stack();
        stk.push(1);
        int ret = 0, val=0, sign=1;
        
        s = s.replaceAll(" ","");
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='+'){
                sign = 1;
            }
            else if(ch == '-'){
                sign = -1;
            }
            else if(ch == '('){
                stk.push(sign*(int)stk.peek());
                sign = 1;
            }
            else if(ch == ')'){
                stk.pop();
            }
            else{
                do{
                    val = val*10 + s.charAt(i) - '0';
                    i++;
                }while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9');
                ret += val*sign*(int)stk.peek();
                val = 0;
                i--;
            }
            
        }
        return ret;
    }
}
