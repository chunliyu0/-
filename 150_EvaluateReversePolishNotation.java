/* Analysis
(1) if it's number, push into the stack
(2) if it's the operator, do the corresponding calculation
(3) pay attention to the order of the operends.
*/

public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null)return 0;
        
        Stack stk = new Stack();
        
        stk.push(Integer.parseInt(tokens[0]));
        for(int i = 1 ;i<tokens.length;i++){
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")){
                stk.push(Integer.parseInt(tokens[i]));
            }
            else{
                int tmp = 0;
                int op1 = (int)stk.pop();
                int op2 = (int)stk.pop();
                //System.out.println("op1 = " + op1 + ", op2 = " + op2);
                if(tokens[i].equals("+"))
                     tmp =  op2 + op1;
                else if(tokens[i].equals("-"))
                     tmp =  op2 - op1;
                else if(tokens[i].equals("*"))
                     tmp =  op2 * op1;
                else if(tokens[i].equals("/"))
                     tmp =  op2 / op1;
        //System.out.println("tmp = " + tmp);
                stk.push(tmp);
            } 
        }
        return (int)stk.pop();
    }
}
