/* Analysis
(1) the basic idea is to do the calculation once we meet "+" or "-"
(2) if there is * or /, then term = term * val, else term = val;
*/

public class Solution {
    public int calculate(String s) {
        //base cases
        if(s==null)return 0;
        
        Stack stack = new Stack();
        int sign = 1, val = 0, term = 1, ret = 0;
        
        //eliminate the spaces
        s = s.replaceAll(" ","");
        s += "+";//each time we meet '+', we will process the previous number
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '+'||ch == '-'){
                ret += term;//do the calculation for the previous number
                sign = (ch == '+'? 1: -1);//decide the sign for the next number
            }
            else if(ch == '*' || ch == '/'){
                sign = (ch == '*' ? 2:-2);//decide the sign for the next number
            }
            else{
                //get the whole number
                val = 0;
                do{ 
                    val = val*10 + s.charAt(i) - '0';
                    i++;
                }while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9');
                i--;
                //decide the value of the term
                if(Math.abs(sign) == 2){
                    term = (sign == 2? term*val : term/val);
                }
                else{
                    term = sign*val;//the sign of the term will be affacted by the first operand.
                }
            }
        }
        return ret;
    }
}
