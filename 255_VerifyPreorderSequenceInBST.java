/* Analysis
Using stack and using the right value to counteract the whole tree
*/

public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length < 2)return true;
        
        Stack<Integer> stk = new Stack<>();
        int min = Integer.MIN_VALUE;
        for(int num: preorder){
            if(num < min)return false;
            while(!stk.isEmpty() && num > stk.peek()){
                min = stk.pop();
            }
            stk.push(num);
        }
        return true;
    }
}
