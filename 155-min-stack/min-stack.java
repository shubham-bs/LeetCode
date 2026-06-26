class MinStack {

    Deque<Integer> main ;
    Deque<Integer> min ;

    public MinStack() {
        main = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }
    
    public void push(int value) {
        main.push(value);
        if(min.isEmpty() || value <= min.peek()){
            min.push(value);
        }
        
    }
    
    public void pop() {
        int flag =main.pop();
        if(flag == min.peek()){
            min.pop();
        }
        
    }
    
    public int top() {
        return main.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */