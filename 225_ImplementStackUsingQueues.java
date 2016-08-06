/* Analysis - two queues*/

class MyStack {
    Queue<Integer> que1 = new LinkedList<>();
    Queue<Integer> que2 = new LinkedList<>();//que2 is just an assisstant;
    
    // Push element x onto stack.
    public void push(int x) {
        while(!que1.isEmpty())
            que2.add(que1.remove());
        que1.add(x);
        while(!que2.isEmpty())
            que1.add(que2.remove());
    }

    // Removes the element on top of the stack.
    public void pop() {
        que1.remove();
    }

    // Get the top element.
    public int top() {
        return que1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return que1.isEmpty();
    }
}
