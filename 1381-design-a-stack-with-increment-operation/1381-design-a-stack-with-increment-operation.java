/*
Use array to represent stack : push and pop from end of the array
*/
class CustomStack {

    int [] st;
    int top;
    public CustomStack(int maxSize) {
        st = new int[maxSize + 1];
        st[0] = 0; // dummy value to handle remove only element from stack
        top = 0; // top of the stack
    }
    
    public void push(int x) {
        if(isFull()) return;
        st[++top] = x;
    }
    
    public int pop() {
        if(isEmpty()) return -1;
        return st[top--];
    }
    
    public void increment(int k, int val) {
        for(int i = 1; i <= k && i <= top; i++) {
            st[i] += val;
        }
    }
    
    private boolean isEmpty() {
        return top == 0;
    }
    
    private boolean isFull() {
        return top == st.length - 1;
    }
    
    
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */