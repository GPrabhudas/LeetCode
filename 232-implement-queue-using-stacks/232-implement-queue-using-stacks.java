class MyQueue {
    Stack<Integer> s;
    Stack<Integer> q;
    public MyQueue() {
        s = new Stack<>();
        q = new Stack<>();
    }
    
    public void push(int x) {
        s.push(x);
    }
    
    public int pop() {
        if(q.empty()) {
            while(!s.empty()) {
                q.push(s.pop());
            }
        }
        
        return q.pop();
    }
    
    public int peek() {
        if(q.empty()) {
            while(!s.empty()) {
                q.push(s.pop());
            }
        }
        
        return q.peek();
    }
    
    public boolean empty() {
        return s.empty() && q.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */