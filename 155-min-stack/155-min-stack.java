class MinStack {
    
    // 1. stack to hold actual values
    Stack<Integer> s;
    
    // 2. stack to hold min valus
    Stack<Integer> ms;
    
    public MinStack() {
        s = new Stack<>();
        ms = new Stack<>();
    }
    
    public void push(int val) {
        // 3. push val in both stacks
        if(s.empty()) {
            s.push(val);
            ms.push(val);
        } else {
            // 4. push val in s
            s.push(val);
            // 5. push min(ms.top(), val) to ms
            if(val < ms.peek()) {
                ms.push(val);
            } else {
                ms.push(ms.peek());
            }
        }
    }
    
    public void pop() {
        s.pop();
        ms.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return ms.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */