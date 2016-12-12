/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        Stack<NestedInteger> stk = new Stack<>();
        int n = s.length(), sign = 1;
        
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '['){
                NestedInteger ni = new NestedInteger();
                stk.push(ni);
            }
            else if(ch == ']'){ //incorporate into the previous nestedInteger
                if(stk.size() > 1){
                    NestedInteger ni = stk.pop();
                    stk.peek().add(ni);
                }
            }
            else if(ch == '-')
                sign = -1;
            else{
                int num = 0;
                while(ch != ','){
                    num = num * 10 + (ch - '0');
                    i++;
                    if(i == n)
                        break;
                    ch = s.charAt(i);
                }
                NestedInteger ni = new NestedInteger(sign * num);
                sign = 1;
                if(stk.isEmpty())
                    stk.add(ni);
                else
                    stk.peek().add(ni);
                
            }
        }
        
        return stk.pop();
    }
}
