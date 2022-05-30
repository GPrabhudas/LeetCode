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
            // 5. push only if current val is less or equal to top of min stack
            if(val <= ms.peek()) {
                ms.push(val);
            }
        }
    }
    
    public void pop() {
        int val = s.pop();
        if(val == ms.peek()) {
            ms.pop();
        }
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