class MinStack {
    private final Deque<Long> stack = new ArrayDeque<>();
    private long min;

    public MinStack() {}
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push((long) val);
            min = val;
        }else if(val >= min){
            stack.push((long) val);
        }else{
            stack.push(2L * val - min);
            min = val;
        }
    }
    
    public void pop() {
        long top = stack.pop();
        if(top < min){
            min = 2*min - top;
        }
    }
    
    public int top() {
        long top = stack.peek();
        if(top >= min){
            return (int) top;
        }else{
            return (int) min;
        }
    }
    
    public int getMin() {
        return (int) min;
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