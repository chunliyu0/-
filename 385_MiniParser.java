/* Analysis - Stack */

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
        if(s==null)return new NestedInteger();
        Stack<NestedInteger> stk = new Stack<>();
        char [] arr = s.toCharArray();
        int sign = 1;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '['){
                NestedInteger ni = new NestedInteger();
                stk.add(ni);
            }
            else if(arr[i] == ']'){//incorporate into the previous nestedInteger
                if(stk.size() > 1){
                    NestedInteger ni = stk.pop();
                    stk.peek().add(ni);
                }
            }
            else if(arr[i] == '-'){
                sign = -1;
            }
            else if(arr[i] == ','){
                continue;
            }
            else{// the character is a digit
                int num = arr[i] - '0';
                while(i+1 < arr.length && arr[i+1] >= '0' && arr[i+1] <= '9'){// we already know that i is valid
                    num = num * 10 + (arr[i+1] - '0');
                    i++;
                }
                NestedInteger ni = new NestedInteger(sign*num);
                sign = 1;
                if(stk.isEmpty())
                    stk.add(ni);
                else
                    stk.peek().add(ni);
            }
        }
        return stk.peek();
        
    }
}
