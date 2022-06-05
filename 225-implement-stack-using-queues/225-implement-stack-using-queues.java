class MyStack {
    Queue<Integer> q1, q2, pushQueue;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        pushQueue = q1;
    }
    
    public void push(int x) {
        pushQueue.add(x);
    }
    
    public int pop() {
        Queue<Integer> temp = pushQueue == q1 ? q2 : q1;
        
        while(pushQueue.size() > 1) {
            temp.add(pushQueue.poll());    
        }
        int value = pushQueue.poll();
        pushQueue = temp;
        return value;
    }
    
    public int top() {
        int p = pop();
        pushQueue.add(p);
        return p;
    }
    
    public boolean empty() {
        return pushQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */