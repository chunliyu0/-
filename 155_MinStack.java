/* Analysis - Using one normal stack and one list to track the correponding minimun element to the current index */

public class MinStack {
    Stack<Integer> stk;
    List<Integer> list;
    
    /** initialize your data structure here. */
    public MinStack() {
        stk = new Stack<>();
        list = new Stack<>();
    }
    
    public void push(int x) {
        stk.push(x);
        if(stk.size()==1)list.add(x);
        else{
            int tmp = list.get(list.size()-1);
            list.add(x < tmp ? x : tmp);
        }
    }
    
    public void pop() {
        stk.pop();
        list.remove(list.size()-1);
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return list.get(list.size()-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
